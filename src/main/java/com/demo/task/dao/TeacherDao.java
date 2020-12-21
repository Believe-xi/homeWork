package com.demo.task.dao;

import com.demo.task.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<TeacherEntity,Integer> {
    TeacherEntity findByNum(String teacherNum);
    List<TeacherEntity> findAllByClassId(int classId);
}
