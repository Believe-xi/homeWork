package com.demo.task.Service;

import com.demo.task.Entity.StudentEntity;
import com.demo.task.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public StudentEntity getStudent(String studentNum){
        return studentDao.findByNum(studentNum);
    }
}