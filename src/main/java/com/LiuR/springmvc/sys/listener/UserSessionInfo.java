package com.LiuR.springmvc.sys.listener;

import com.LiuR.springmvc.sys.config.AppContextUtil;
import com.LiuR.springmvc.sys.constant.ConstantValues;
import com.LiuR.springmvc.test.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSessionInfo {

    /**
     * 获取当前用户---从session中
     * @return
     */
    public static synchronized User getCurrentUser(){
        HttpServletRequest request = AppContextUtil.getRequest();
        HttpSession session = null;
        if(request != null){
            session = request.getSession(false);
        }
        User user = null;
        if(session != null && session.getAttribute(ConstantValues.USERINFO) != null){
            user = (User) session.getAttribute(ConstantValues.USERINFO);
        }
        return user;
    }

    public static synchronized void setCurrentUser(User user){
        if(user != null){
            AppContextUtil.getRequest().getSession().invalidate();
            HttpSession session = AppContextUtil.getRequest().getSession();
            session.setAttribute(ConstantValues.USERINFO, user);
        }
    }

}
