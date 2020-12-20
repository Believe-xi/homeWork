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

    @PostMapping("/saveUser")
    public ResponseEntity<UserEntity> saveUser(HttpServletRequest request, HttpServletResponse response){
        UserEntity userEntity = null;
        String userNum = request.getParameter("userNum");
        String identity = request.getParameter("identity");
        //判断身份 创建/更新 学生/教师 实体
        if(identity.equals("学生")){
            //从数据库获取信息
            userEntity = studentService.getStudent(userNum);
            //查无此人则新建
            if(userEntity == null){
                userEntity = new StudentEntity();
            }
        }
        else if(request.getParameter("identity").equals("教师")){
            userEntity = teacherService.getTeacher(userNum);
            if(userEntity == null){
                userEntity = new TeacherEntity();
            }
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
