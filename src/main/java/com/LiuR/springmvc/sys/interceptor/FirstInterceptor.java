package com.LiuR.springmvc.sys.interceptor;

import com.LiuR.springmvc.sys.listener.UserSessionInfo;
import com.LiuR.springmvc.test.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

             }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
             throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        User user = UserSessionInfo.getCurrentUser();
        if (user != null) {
            return true;
        } else {
            response.sendRedirect("../login.jsp");
            return false;
        }
    }
}
