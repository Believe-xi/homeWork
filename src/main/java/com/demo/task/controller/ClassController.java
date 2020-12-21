package com.demo.task.controller;

import com.demo.task.Entity.ClassEntity;
import com.demo.task.Service.ClassService;
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

    @PostMapping("/saveClass")
    public ResponseEntity<String> addClass(HttpServletRequest request){
        ClassEntity classEntity;
        //根据classId从数据库获取
        classEntity = classService.getClass(Integer.parseInt(request.getParameter("classId")));
        //若数据库无此班级则新建
        if(classEntity == null){
            classEntity = new ClassEntity();
        }
        classEntity.setMajor(request.getParameter("major"));
        classEntity.setNum(Integer.parseInt(request.getParameter("classNum")));
        classService.saveClass(classEntity);
        return new ResponseEntity<>(200,"success");
    }

    @PostMapping("/allClass")
    public ResponseEntity<List<ClassEntity>> allClass(){
        ResponseEntity<List<ClassEntity>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(200);
        responseEntity.setMsg("success");
        responseEntity.setData(classService.getAllClass());
        return responseEntity;
    }

}










