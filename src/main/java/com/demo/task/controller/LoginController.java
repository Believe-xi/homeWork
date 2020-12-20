package com.demo.task.controller;

import com.demo.task.Entity.StudentEntity;
import com.demo.task.Service.ClassService;
import com.demo.task.Service.StudentService;
import com.demo.task.UtilEntity.ResponseEntity;
import com.demo.task.UtilEntity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@RestController
public class LoginController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @PostMapping("/login")
    public ResponseEntity login(HttpServletRequest request, HttpServletResponse response){

        //将请求体中的参数提取，减少调用getparameter方法的次数
        String requestUserNum = request.getParameter("userNum");
        String requestPassWord = request.getParameter("passWord");
        String requestIdentity = request.getParameter("Authentication");

        //创建返回体与学生实体
        ResponseEntity loginResponse = new ResponseEntity();
        StudentEntity studentEntity = studentService.getStudent(requestUserNum);

        //如果用户不存在
        if(studentEntity == null){
            loginResponse.setStatus(201);
            loginResponse.setMsg("用户不存在！");
        }
        //如果用户密码与数据库不匹配
        else if(requestPassWord.equals(studentEntity.getPassWord())){
            loginResponse.setStatus(200);
            loginResponse.setMsg("成功！");

            //创建userInfo，并添加数据，最后将userInfo放入响应体的data内
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(studentEntity.getName());
            userInfo.setUserNum(studentEntity.getNum());
            userInfo.setSex(studentEntity.getSex());
            userInfo.setMajor(classService.getClass(studentEntity.getClassId()).getMajor());
            userInfo.setClassNum(classService.getClass(studentEntity.getClassId()).getNum());
            loginResponse.setData(userInfo);

            //给响应消息添加cookie
            response.addCookie(new Cookie("userNum",userInfo.getUserNum()));
            response.addCookie(new Cookie("userName",userInfo.getUserName()));
            response.addCookie(new Cookie("sex",userInfo.getSex()));
            response.addCookie(new Cookie("Major",userInfo.getMajor()));
            response.addCookie(new Cookie("className",String.valueOf(userInfo.getClassNum())));

//            HttpSession session = request.getSession();
//            session.setAttribute("user",userInfo);
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
