package com.sunshine.cloudhttp.server;

import com.sunshine.cloudhttp.HttpParser;
import com.sunshine.cloudhttp.Request;
import com.sunshine.cloudhttp.Response;
import com.sunshine.cloudhttp.constant.HttpCode;
import com.sunshine.cloudhttp.exception.ViewNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * RequestWorker
 *
 * @author wangjn
 * @date 2019/3/31
 */
public class RequestWorker implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(RequestWorker.class);

    private Request request;

    private SelectionKey key;

    private SocketChannel channel;

    private CloudService cloudService;

    public RequestWorker(Request request, SelectionKey key, CloudService cloudService) {
        this.request = request;
        this.key = key;
        this.channel = (SocketChannel) key.channel();
        this.cloudService = cloudService;
    }

    @Override
    public void run() {
        Response response = new Response();
        try {
            cloudService.doService(request, response);
        } catch (ViewNotFoundException e) {
            response.setCode(HttpCode.STATUS_404.getCode());
            response.setMsg(HttpCode.STATUS_404.getMsg());
            ByteArrayOutputStream outputStream = response.getOutPutStream();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("404.html");
            byte bytes [] = new byte [1024];
            int len;
            try {
                while ((len = inputStream.read(bytes)) > -1) {
                    outputStream.write(bytes, 0, len);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            response.getOutPutStream();
        }
        byte [] resHeader = HttpParser.encodeResHeader(response);
        byte [] body = response.getOutPutStream().toByteArray();

        ByteBuffer byteBuffer = ByteBuffer.allocate(resHeader.length + body.length);
        byteBuffer.put(resHeader);
        byteBuffer.put(body);
        byteBuffer.flip();
        // 将输出流绑定至附件
        key.attach(byteBuffer);
        // 注册写事件
        key.interestOps(SelectionKey.OP_WRITE);
        key.selector().wakeup();
    }
}
