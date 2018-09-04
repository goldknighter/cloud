package com.awifi.hghtest.zuul.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

// Zuul过滤器
@Component
public class DemoFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(DemoFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = String.format("%s >>> %s>>> %s", request.getMethod(), request.getRequestURL().toString(), request.getQueryString());
        log.info(s);
        return null;
    }
}