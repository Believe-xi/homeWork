package com.demo.task.dao;


import com.demo.task.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity,Integer>{
    StudentEntity findByNum(String num);
}
