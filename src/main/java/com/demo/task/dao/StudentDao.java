package com.demo.task.dao;


import com.demo.task.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<StudentEntity,Integer>{
    StudentEntity findByNum(String num);
    List<StudentEntity> findAllByClassId(int classId);
    void deleteById(int studentId);
    void deleteByNum(String studentNum);
}
