package com.demo.task.Service;

import com.demo.task.Entity.StudentEntity;
import com.demo.task.dao.StudentDao;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TaskService taskService;

    public StudentEntity getStudent(String studentNum){
        return studentDao.findByNum(studentNum);
    }

    public List<StudentEntity> getAllStudent(){
        return studentDao.findAll();
    }

    public List<StudentEntity> getAllStudentByClassId(int classId){
        return studentDao.findAllByClassId(classId);
    }

    public StudentEntity saveStudent(StudentEntity studentEntity){
        return studentDao.save(studentEntity);
    }

    public void deleteStudent(StudentEntity studentEntity){
        studentDao.delete(studentEntity);
    }

    public void deleteStudentById(int studentId){
        taskService.deleteTaskByStudentId(studentId);
        studentDao.deleteById(studentId);
    }

    public void deleteAllStudentByClassId(int classId){
        List<StudentEntity> studentList = getAllStudentByClassId(classId);
        for(StudentEntity student : studentList){
            deleteStudentById(student.getId());
        }
    }
}
