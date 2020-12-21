package com.demo.task.controller;

import com.demo.task.Entity.TaskEntity;
import com.demo.task.Service.TaskService;
import com.demo.task.UtilEntity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.demo.task.Utils.CookieUtil.getCookieValue;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/allTask")
    public ResponseEntity<List<TaskEntity>> getAllTask(){
        return new ResponseEntity<>(200,"Success!",taskService.getAllTask());
    }

    @PostMapping("/submitTask")
    public ResponseEntity<TaskEntity> submitTask(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStudentId(Integer.parseInt(getCookieValue(cookies, "userId")));
        taskEntity.setTitle(request.getParameter("title"));
        taskEntity.setContent(request.getParameter("content"));
        return new ResponseEntity<>(200,"Success", taskService.saveTask(taskEntity));
    }

    @PostMapping("/ownTask")
    public ResponseEntity<List<TaskEntity>> getOwnTask(HttpServletRequest request){

        return new ResponseEntity<>(200,"Success!",taskService.getOwnTask(Integer.parseInt(getCookieValue(request.getCookies(), "userId"))));
    }

    @PostMapping("/getTask")
    public ResponseEntity<TaskEntity> getTask(HttpServletRequest request){
        return new ResponseEntity<>(200,"Success!", taskService.getTask(Integer.parseInt(request.getParameter("taskId"))));
    }

    @PostMapping("/evaluate")
    public ResponseEntity<String> evaluateTask(HttpServletRequest request){
        TaskEntity taskEntity = taskService.getTask(Integer.parseInt(request.getParameter("taskId")));
        taskEntity.setEvaluation(request.getParameter("evaluation"));
        taskEntity.setGrade(Integer.parseInt(request.getParameter("grade")));
        taskService.saveTask(taskEntity);
        return new ResponseEntity<>(200,"success!");
    }

    @PostMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(HttpServletRequest request){
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        taskService.deleteTaskByStudentId(studentId);
        return new ResponseEntity<>(200,"success");
    }
}


























