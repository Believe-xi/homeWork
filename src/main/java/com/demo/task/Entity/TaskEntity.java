package com.demo.task.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "homework")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class TaskEntity {
    @Id
    @Column(name = "homework_id")
    private int id;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "homework_title")
    private String title;
    @Column(name = "homework_content")
    private String content;
    @Column(name = "homework_evaluation")
    private String evaluation;
    @Column(name = "homework_grade")
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
