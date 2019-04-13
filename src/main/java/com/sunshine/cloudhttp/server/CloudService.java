package com.sunshine.cloudhttp.server;

import com.sunshine.cloudhttp.Request;
import com.sunshine.cloudhttp.Response;
import com.sunshine.cloudhttp.servlet.CloudServlet;
import com.sunshine.cloudhttp.servlet.MappingUrlServlet;
import com.sunshine.cloudhttp.servlet.StaticViewServlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CloudService
 *
 * @author wangjn
 * @date 2019/4/3
 */
public class CloudService {

    private List<CloudServlet> cloudServlets = new ArrayList<>();

    public CloudService() {
        cloudServlets.add(new StaticViewServlet());
        cloudServlets.add(new MappingUrlServlet());
    }

    public void doService(Request request, Response response) {
        CloudServlet servlet = doSelect(request);
        servlet.init(request, response);
        servlet.doService(request, response);
    }

    private CloudServlet doSelect(Request request) {
        for (CloudServlet cloudServlet : cloudServlets) {
            if (cloudServlet.match(request)) {
                return cloudServlet;
            }
        }
        return new MappingUrlServlet();
    }
}
