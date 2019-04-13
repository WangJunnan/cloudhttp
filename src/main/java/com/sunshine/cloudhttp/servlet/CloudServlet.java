package com.sunshine.cloudhttp.servlet;

import com.sunshine.cloudhttp.Request;
import com.sunshine.cloudhttp.Response;

/**
 * CloudServlet
 *
 * @author wangjn
 * @date 2019/4/3
 */
public interface CloudServlet {

    /**
     * 判断当前请求是否匹配 handler
     *
     * @param request
     * @return
     */
    boolean match(Request request);

    /**
     * 执行初始化
     */
    void init(Request request, Response response);

    /**
     * 执行请求
     *
     * @param request
     * @param response
     */
    void doService(Request request, Response response);
}
