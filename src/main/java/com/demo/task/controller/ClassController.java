package com.demo.task.controller;

import com.demo.task.Entity.ClassEntity;
import com.demo.task.Service.ClassService;
import com.demo.task.UtilEntity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @PostMapping("/addClass")
    public ResponseEntity<String> addClass(HttpServletRequest request, HttpServletResponse response){
        ClassEntity classEntity = new ClassEntity();
        classEntity.setMajor(request.getParameter("major"));
        classEntity.setNum(Integer.parseInt(request.getParameter("classNum")));
        classService.saveClass(classEntity);
        return new ResponseEntity<>(200,"success");
    }

    @PostMapping("/allClass")
    public ResponseEntity<List<ClassEntity>> allClass(HttpServletRequest request, HttpServletResponse response){
        ResponseEntity<List<ClassEntity>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(200);
        responseEntity.setMsg("success");
        responseEntity.setData(classService.getAllClass());
        return responseEntity;
    }

    @PostMapping("/alterClass")
    public ResponseEntity<ClassEntity> alterClass(HttpServletRequest request, HttpServletResponse response){
        ClassEntity classEntity = classService.getClass(Integer.parseInt(request.getParameter("classId")));
        classEntity.setMajor(request.getParameter("major"));
        classEntity.setNum(Integer.parseInt(request.getParameter("classNum")));
        classService.saveClass(classEntity);
        ResponseEntity<ClassEntity> responseEntity = new ResponseEntity<>(200,"success");
        responseEntity.setData(classEntity);
        return responseEntity;
    }
}










