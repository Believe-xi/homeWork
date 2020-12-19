package com.demo.task.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class StudentEntity {
    @Id
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_num")
    private String num;
    @Column(name = "student_password")
    private String passWord;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_sex")
    private String sex;
    @Column(name = "class_id")
    private int classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
