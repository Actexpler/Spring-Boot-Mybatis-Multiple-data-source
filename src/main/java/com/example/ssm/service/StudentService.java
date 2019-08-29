package com.example.ssm.service;

import com.example.ssm.mapper.student.studentMapper;
import com.example.ssm.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private studentMapper sMapper;

    public Student getStudent(int id) {
        return sMapper.get(id);
//        Student student = new Student();
//        student.setId(1111);
//        student.setName("张三");
//        return student;
    }
}
