package com.demo.task.controller;

import com.demo.task.Entity.TaskEntity;
import com.demo.task.Service.TaskService;
import com.demo.task.UtilEntity.CookieUtil;
import com.demo.task.UtilEntity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;
    CookieUtil cookieUtil;

    @PostMapping("/allTask")
    public ResponseEntity<List<TaskEntity>> getAllTask(HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<>(200,"Success!",taskService.getAllTask());
    }

    @PostMapping("/submitTask")
    public ResponseEntity<TaskEntity> submitTask(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStudentId(Integer.parseInt(cookieUtil.getCookieValue(cookies, "userId")));
        taskEntity.setTitle(request.getParameter("title"));
        taskEntity.setContent(request.getParameter("content"));
        return new ResponseEntity<>(200,"Success", taskService.submitTask(taskEntity));
    }
}
