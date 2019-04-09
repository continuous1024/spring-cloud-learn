package com.huanyu.cloud.learn.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
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
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String name = httpServletRequest.getParameter("name");
        if (name == null) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("name is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
