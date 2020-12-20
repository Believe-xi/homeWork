package com.demo.task.UtilEntity;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public String getCookieValue(Cookie[] cookies, String name){
        String value = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("userNum")){
                value = cookie.getValue();
            }
        }
        return value;
    }
}
