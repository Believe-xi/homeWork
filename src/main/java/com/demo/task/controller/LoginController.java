package com.demo.task.controller;

import com.demo.task.utils.ResponseMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseMsg login(HttpServletRequest request){
        System.out.println(request.getParameter("userName"));
        System.out.println(request.getParameter("passWord"));
        System.out.println(request.getParameter("Authentication"));
        return new ResponseMsg(200,"成功");
    }
}
