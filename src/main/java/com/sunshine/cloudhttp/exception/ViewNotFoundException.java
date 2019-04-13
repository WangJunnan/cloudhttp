package com.sunshine.cloudhttp.exception;

/**
 * ViewNotFoundException
 *
 * @author wangjn
 * @date 2019/4/13
 */
public class ViewNotFoundException extends RuntimeException {

    public ViewNotFoundException() {
        super("404 页面丢失了！！");
    }
}
