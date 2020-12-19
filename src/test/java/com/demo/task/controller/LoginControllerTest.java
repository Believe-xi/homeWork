package com.demo.task.controller;

import com.demo.task.UtilEntity.ResponseEntity;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

class LoginControllerTest {

    @Test
    public ResponseEntity login(HttpServletRequest request){
        System.out.println(request.getParameter("userName"));
        System.out.println(request.getParameter("passWord"));
        System.out.println(request.getParameter("Authentication"));
        return new ResponseEntity(200,"成功");
    }
}