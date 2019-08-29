package com.example.ssm.service;

import com.example.ssm.mapper.teacher.teacherMapper;
import com.example.ssm.pojo.Teacher;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherService {

    @Resource
    @Qualifier("teacherSqlSessionTemplate")
    SqlSessionTemplate wmsSqlSessionTemplate;

    public Teacher getTeacher(int id) {
        System.out.println("service");
        return wmsSqlSessionTemplate.getMapper(teacherMapper.class).getTeacher(id);
    }
}
