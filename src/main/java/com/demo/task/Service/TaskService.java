package com.demo.task.Service;

import com.demo.task.Entity.TaskEntity;
import com.demo.task.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;

    public List<TaskEntity> getAllTask(){
        return taskDao.findAll();
    }

    public List<TaskEntity> getAllTaskByStudentId(int studentId){
        return taskDao.findAllByStudentId(studentId);
    }

    public TaskEntity saveTask(TaskEntity taskEntity){
        return taskDao.save(taskEntity);
    }

    public List<TaskEntity> getOwnTask(int id){
        return taskDao.findAllByStudentId(id);
    }

    public TaskEntity getTask(int id){
        return taskDao.findById(id);
    }
}
