package com.demo.task.dao;


import com.demo.task.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findAll();
    List<TaskEntity> findAllByStudentId(int studentId);
}
