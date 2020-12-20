package com.demo.task.UtilEntity;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static String getCookieValue(Cookie[] cookies, String name){
        String value = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(name)){
                value = cookie.getValue();
            }
        }
        return value;
    }

    public static void printAllCookie(Cookie[] cookies){
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.print(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }
    }
}
