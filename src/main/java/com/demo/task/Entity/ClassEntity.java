package com.demo.task.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class ClassEntity {
    @Id
    @Column(name = "class_id")
    private int classId;
    @Column(name = "class_major")
    private String major;
    @Column(name = "class_num")
    private int num;

    public int getId() {
        return classId;
    }

    public void setId(int id) {
        this.classId = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
