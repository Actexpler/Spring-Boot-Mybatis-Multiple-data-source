package com.example.ssm.mapper.student;

import com.example.ssm.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface studentMapper {
    Student get(int id);
}
