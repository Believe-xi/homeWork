package com.demo.task.dao;

import com.demo.task.Entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassDao extends JpaRepository<ClassEntity,Integer> {
    ClassEntity findById(int ClassId);
}
