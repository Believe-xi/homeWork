package com.demo.task.dao;

import com.demo.task.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<TeacherEntity,Integer> {
    TeacherEntity findByNum(String teacherNum);
}
