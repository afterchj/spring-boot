package com.example.demo.interceptor;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hongjian.chen on 2018/8/24.
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        requestUri = requestUri.substring(contextPath.length(), requestUri.length());
        if (!requestUri.endsWith(".js")) {
            System.out.println("url=" + requestUri + "，请求处理时间为" + (System.currentTimeMillis() - startTime));
        }
    }
}
