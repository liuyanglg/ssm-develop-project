package com.aisino.admin.global.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext atx;

    public void setApplicationContext(ApplicationContext atx)
            throws BeansException {
        // TODO Auto-generated method stub
        this.atx = atx;
    }

    public static ApplicationContext getAtx() {
        return atx;
    }

    public static Object getBean(String beanName) {
        return getAtx().getBean(beanName);
    }

    private HttpServletRequest request;
    private HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

}
