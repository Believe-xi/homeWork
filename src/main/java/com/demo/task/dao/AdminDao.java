package com.demo.task.dao;

import com.demo.task.Entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<AdminEntity,Integer> {
    AdminEntity findByAdminNum(String adminNum);
}
