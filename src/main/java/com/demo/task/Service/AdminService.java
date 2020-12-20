package com.demo.task.Service;

import com.demo.task.Entity.AdminEntity;
import com.demo.task.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public AdminEntity getAdmin(String adminNum){
        return adminDao.findByAdminNum(adminNum);
    }
}
