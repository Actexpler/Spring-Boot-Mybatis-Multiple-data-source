package com.example.testdatasource.mapper;

import com.example.testdatasource.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    Teacher getTeacher(String id);
}
