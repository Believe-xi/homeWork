package com.demo.task.Service;

import com.demo.task.Entity.TeacherEntity;
import com.demo.task.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public TeacherEntity getTeacher(String teacherNum){
        return teacherDao.findByNum(teacherNum);
    }
}
