package com.demo.task.controller;

import com.demo.task.Service.ClassService;
import com.demo.task.Service.StudentService;
import com.demo.task.Service.TeacherService;
import com.demo.task.UtilEntity.ResponseEntity;
import com.demo.task.UtilEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassService classService;


    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response){

        //将请求体中的参数提取，减少调用getparameter方法的次数
        String requestUserNum = request.getParameter("userNum");
        String requestPassWord = request.getParameter("passWord");
        String requestIdentity = request.getParameter("Authentication");

        //创建返回体与学生实体
        ResponseEntity<String> loginResponse = new ResponseEntity<>();
        UserEntity userEntity;
        if(requestIdentity.equals("学生")){
            userEntity = studentService.getStudent(requestUserNum);
        }
        else if(requestIdentity.equals("教师")){
            userEntity = teacherService.getTeacher(requestUserNum);
        }
        else{
            userEntity = null;
        }

        //如果用户不存在
        if(userEntity == null){
            loginResponse.setStatus(201);
            loginResponse.setMsg("用户不存在！");
        }
        //如果用户密码与数据库不匹配
        else if(requestPassWord.equals(userEntity.getPassWord())){
            loginResponse.setStatus(200);
            loginResponse.setMsg("成功！");
            //给响应消息添加cookie
            response.addCookie(new Cookie("userId",String.valueOf(userEntity.getId())));
            response.addCookie(new Cookie("userNum",userEntity.getNum()));
            response.addCookie(new Cookie("userName",userEntity.getName()));
            response.addCookie(new Cookie("sex",userEntity.getSex()));
            response.addCookie(new Cookie("Major",classService.getClass(userEntity.getClassId()).getMajor()));
            response.addCookie(new Cookie("className",String.valueOf(classService.getClass(userEntity.getClassId()).getNum())));
            response.addCookie(new Cookie("Identity",requestIdentity));
        }
        //其他情况
        else{
            loginResponse.setStatus(201);
            loginResponse.setMsg("失败！");
        }

        //返回响应体
        return loginResponse;
    }
}
