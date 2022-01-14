package com.LiuR.springmvc.sys.util;

import com.LiuR.springmvc.sys.config.AppContextUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestUtil {
    public static Map<String, String> getParameterMap() {
        HttpServletRequest request = AppContextUtil.getRequest();
        Map<String, String[]> properties = request.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        String[] values = null;
        for(String name : properties.keySet()){
            name = name.toString();
            values = properties.get(name);

            if(values == null || values.length <= 0){
                continue;
            }
            returnMap.put(name, values[0].toString());

        }
        return format(returnMap);
    }

    private static Map<String, String> format(Map<String, String> returnMap){
        if(returnMap == null){
            return new HashMap<String, String>();
        }
        String value = "";
        for(String name : returnMap.keySet()){
            name = name.toString();
            value = returnMap.get(name);
            if(name.equals("content") || name.equals("opinion")){
                value = value.toString();
                value = value.toString();
                returnMap.put(name, value);
            }else{
                returnMap.put(name, value.toString());
            }
        }
        return returnMap;
    }
}
