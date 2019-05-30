package com.example.blt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by after on 2019/5/30.
 */
public class ServletUtil {

   private static Logger logger= LoggerFactory.getLogger(ServletUtil.class);

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return requestAttributes.getRequest();
        } else {
            return null;
        }
    }

    public static HttpSession getSession() {
        if (getRequest() != null) {
            return getRequest().getSession();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        logger.info("session=" + getSession());
    }
}
