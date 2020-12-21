package com.demo.task.Service;

import com.demo.task.Entity.ClassEntity;
import com.demo.task.dao.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassDao classDao;

    public ClassEntity getClass(int classId){
        return classDao.findById(classId);
    }

    public ClassEntity saveClass(ClassEntity classEntity){
        return classDao.save(classEntity);
    }

    public List<ClassEntity> getAllClass(){
        return classDao.findAll();
    }

    public void deleteClass(ClassEntity classEntity){
         classDao.delete(classEntity);
    }
}
