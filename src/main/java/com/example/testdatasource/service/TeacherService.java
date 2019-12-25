package com.example.testdatasource.service;

import com.example.testdatasource.mapper.TeacherMapper;
import com.example.testdatasource.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper tMapper;

    public Teacher getTeacher(String id) {
        return tMapper.getTeacher(id);
    }
}
