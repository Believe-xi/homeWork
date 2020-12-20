package com.demo.task.Service;

import com.demo.task.Entity.TeacherEntity;
import com.demo.task.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public TeacherEntity getTeacher(String teacherNum){
        return teacherDao.findByNum(teacherNum);
    }
    public List<TeacherEntity> getAllTeacher(){
        return teacherDao.findAll();
    }
    public TeacherEntity saveTeacher(TeacherEntity teacherEntity){
        return teacherDao.save(teacherEntity);
    }
}
