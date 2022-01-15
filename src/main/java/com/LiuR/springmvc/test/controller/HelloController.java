package com.LiuR.springmvc.test.controller;

import com.LiuR.springmvc.sys.util.RequestUtil;
import com.LiuR.springmvc.test.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }

    @RequestMapping("/getparams")
    public String getParams(String name, String password){
        Map<String, String> parameterMap = RequestUtil.getParameterMap();
        String s = parameterMap.get("name");
        System.out.println(name);
        System.out.println("name:" + s);

        return "index";
    }

    @RequestMapping("tosubmit")
    public String toSubmit(){
        return "submit";
    }

    @RequestMapping("testjackson")
    @ResponseBody
    public User testJackson(){
        return new User(1001,"admin","男",20);
    }
}
