package com.LiuR.springmvc.sys.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AppContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContextUtil.applicationContext = applicationContext;
    }

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if(servletRequestAttributes != null){
            request = servletRequestAttributes.getRequest();
        }
        return request;
    }

    public static <T> T getBean(String a, Class clazz){
        return (T)applicationContext.getBean(a, clazz);
    }

    public Object getBean(String a){
        return applicationContext.getBean(a);
    }
}
