package com.demo.task.controller;

import com.demo.task.Entity.StudentEntity;
import com.demo.task.Entity.TeacherEntity;
import com.demo.task.Service.StudentService;
import com.demo.task.Service.TeacherService;
import com.demo.task.UtilEntity.ResponseEntity;
import com.demo.task.UtilEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @PostMapping("/addUser")
    public ResponseEntity<UserEntity> addTeacher(HttpServletRequest request, HttpServletResponse response){
        UserEntity userEntity = null;
        String identity = request.getParameter("identity");
        //判断身份创建学生/教师实体
        if(identity.equals("学生")){
            userEntity = new StudentEntity();
        }
        else if(request.getParameter("identity").equals("教师")){
            userEntity = new TeacherEntity();
        }
        //设置用户属性
        userEntity.setNum(request.getParameter("userNum"));
        userEntity.setPassWord(request.getParameter("passWord"));
        userEntity.setName(request.getParameter("userName"));
        userEntity.setSex(request.getParameter("sex"));
        userEntity.setClassId(Integer.parseInt(request.getParameter("classId")));
        //保存用户数据
        if(identity.equals("学生")){
            studentService.saveStudent((StudentEntity) userEntity);
        }
        else if(request.getParameter("identity").equals("教师")){
            teacherService.saveTeacher((TeacherEntity) userEntity);
        }

        ResponseEntity<UserEntity> responseEntity = new ResponseEntity<>(200,"success");
        responseEntity.setData(userEntity);
        return responseEntity;
    }

    @PostMapping("/allUser")
    public ResponseEntity allUser(HttpServletRequest request, HttpServletResponse response){
        String identity = request.getParameter("identity");
        ResponseEntity responseEntity = new ResponseEntity<>(200,"success");
        if(identity.equals("学生")){
            responseEntity.setData(studentService.getAllStudent());
        }
        else if(identity.equals("教师")){
            responseEntity.setData(teacherService.getAllTeacher());
        }
        return responseEntity;
    }
}
