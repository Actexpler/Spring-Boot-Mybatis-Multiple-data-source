package com.example.testdatasource.mapper.student;

import com.example.testdatasource.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student getStudent(String id);

    List<Student> getList();
}
