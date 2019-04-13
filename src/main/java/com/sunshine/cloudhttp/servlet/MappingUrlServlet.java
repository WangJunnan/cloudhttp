package com.sunshine.cloudhttp.servlet;

import com.sunshine.cloudhttp.Request;
import com.sunshine.cloudhttp.Response;

/**
 * MappingUrlServlet
 *
 * @author wangjn
 * @date 2019/4/10
 */
public class MappingUrlServlet implements CloudServlet {

    @Override
    public boolean match(Request request) {
        return true;
    }

    @Override
    public void init(Request request, Response response) {

    }

    @Override
    public void doService(Request request, Response response) {

    }
}
