package com.LiuR.springmvc.test.controller;

import com.LiuR.springmvc.sys.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
