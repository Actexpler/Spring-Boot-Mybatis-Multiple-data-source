package com.example.testdatasource.service;

import com.example.testdatasource.mapper.student.StudentMapper;
import com.example.testdatasource.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper sMapper;

    public Student getStudent(String id) {
        return sMapper.getStudent(id);
    }

    public List<Student> getList() {
        return sMapper.getList();
    }
}
