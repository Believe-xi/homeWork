package com.demo.task.controller;

import com.demo.task.Entity.ClassEntity;
import com.demo.task.Service.ClassService;
import com.demo.task.Service.StudentService;
import com.demo.task.UtilEntity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;

    @PostMapping("/saveClass")
    public ResponseEntity<ClassEntity> addClass(HttpServletRequest request){
        ResponseEntity<ClassEntity> responseEntity = new ResponseEntity<>();
        String classId = request.getParameter("classId");
        ClassEntity classEntity = null;
        //如果没有classId参数,则新建
        if(classId == null){
            classEntity = new ClassEntity();
            responseEntity.setStatus(200);
            responseEntity.setMsg("create class success");
        }
        //如果可以从数据库获取到班级数据
        else if(classService.getClass(Integer.parseInt(classId)) != null){
            classEntity = classService.getClass(Integer.parseInt(classId));
            responseEntity.setStatus(200);
            responseEntity.setMsg("update class success");
        }
        //有classId但是数据库没有此classId对应的班级数据,返回错误信息
        else{
            responseEntity.setStatus(201);
            responseEntity.setMsg("class is not exists for this classId");
        }

        if(responseEntity.getStatus() == 200){
            assert classEntity != null;
            classEntity.setMajor(request.getParameter("major"));
            classEntity.setNum(Integer.parseInt(request.getParameter("classNum")));
            classService.saveClass(classEntity);
            responseEntity.setData(classEntity);
        }
        return responseEntity;
    }

    @PostMapping("/allClass")
    public ResponseEntity<List<ClassEntity>> allClass(){
        ResponseEntity<List<ClassEntity>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(200);
        responseEntity.setMsg("success");
        responseEntity.setData(classService.getAllClass());
        return responseEntity;
    }

    @PostMapping("/deleteClass")
    public ResponseEntity<String> deleteClass(HttpServletRequest request){
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        ClassEntity classEntity = classService.getClass(Integer.parseInt(request.getParameter("classId")));
        if(classEntity != null){
            classService.deleteClass(classEntity);
            responseEntity.setStatus(200);
            responseEntity.setMsg("success");
        }
        else{
            responseEntity.setStatus(201);
            responseEntity.setMsg("class is not exists");
        }
        return responseEntity;
    }
}










