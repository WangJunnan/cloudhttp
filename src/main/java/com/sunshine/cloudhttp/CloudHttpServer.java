package com.sunshine.cloudhttp;

import com.sunshine.cloudhttp.server.NioServer;

/**
 * CloudHttpServer
 *
 * @author wangjn
 * @date 2019/3/31
 */
public class CloudHttpServer {

    /**
     * 启动服务器
     */
    public static void startServer() {
        NioServer.getServerInstance().start();
    }

    public static void main(String[] args) {
        startServer();
    }
}
