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
import java.util.List;

@RestController
public class UserController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserEntity> saveUser(HttpServletRequest request){
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

        if(userEntity != null){
            //设置用户属性
            userEntity.setNum(request.getParameter("userNum"));
            userEntity.setPassWord(request.getParameter("passWord"));
            userEntity.setName(request.getParameter("userName"));
            userEntity.setSex(request.getParameter("sex"));
            userEntity.setClassId(Integer.parseInt(request.getParameter("classId")));
        }

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
    public ResponseEntity allUser(HttpServletRequest request){
        String identity = request.getParameter("identity");
        if(identity.equals("学生")){
            ResponseEntity<List<StudentEntity>> responseEntity = new ResponseEntity<>(200,"success");
            responseEntity.setData(studentService.getAllStudent());
            return responseEntity;
        }
        else if(identity.equals("教师")){
            ResponseEntity<List<TeacherEntity>> responseEntity = new ResponseEntity<>(200,"success");
            responseEntity.setData(teacherService.getAllTeacher());
            return responseEntity;
        }
        else {
            return new ResponseEntity<String>(201,"身份信息输入有误");
        }
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<UserEntity> deleteUser(HttpServletRequest request){
        ResponseEntity<UserEntity> responseEntity = new ResponseEntity<>();
        UserEntity userEntity;
        String userNum = request.getParameter("userNum");
        String identity = request.getParameter("identity");
        if(identity.equals("学生")){
            userEntity = studentService.getStudent(userNum);
            if(userEntity == null){
                responseEntity.setStatus(201);
                responseEntity.setMsg("user is not exists for this userNum & identity");
            }
            else{
                studentService.deleteStudent((StudentEntity)userEntity);
                responseEntity.setData(userEntity);
            }
        }
        else if(identity.equals("教师")){
            userEntity = teacherService.getTeacher(userNum);
            if(userEntity == null){
                responseEntity.setStatus(201);
                responseEntity.setMsg("user is not exists for this userNum & identity");
            }
            else{
                teacherService.deleteTeacher((TeacherEntity)userEntity);
                responseEntity.setData(userEntity);
            }
        }
        else{
            responseEntity.setStatus(201);
            responseEntity.setMsg("user is not exists for this userNum & identity");
        }
        return  responseEntity;
    }

}
