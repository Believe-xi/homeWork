package com.demo.task.controller;

import com.demo.task.Entity.StudentEntity;
import com.demo.task.Service.ClassService;
import com.demo.task.Service.StudentService;
import com.demo.task.UtilEntity.ResponseEntity;
import com.demo.task.UtilEntity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @PostMapping("/login")
    public ResponseEntity login(HttpServletRequest request){
        String requestUserNum = request.getParameter("userNum");
        String requestPassWord = request.getParameter("passWord");

        ResponseEntity loginResponse = new ResponseEntity();
        StudentEntity studentEntity = studentService.getStudent(requestUserNum);

        if(studentEntity == null){
            loginResponse.setStatus(201);
            loginResponse.setMsg("用户不存在！");
        }
        else if(requestPassWord.equals(studentEntity.getPassWord())){
            loginResponse.setStatus(200);
            loginResponse.setMsg("成功！");
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(studentEntity.getName());
            userInfo.setUserNum(studentEntity.getNum());
            userInfo.setMajor(classService.getClass(studentEntity.getClassId()).getMajor());
            userInfo.setClassNum(classService.getClass(studentEntity.getClassId()).getNum());
            loginResponse.setData(userInfo);
        }
        else{
            loginResponse.setStatus(201);
            loginResponse.setMsg("失败！");
        }
        return loginResponse;
    }
}
