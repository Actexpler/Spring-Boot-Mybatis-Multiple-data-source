package com.example.ssm.mapper.teacher;

import com.example.ssm.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface teacherMapper {
    Teacher getTeacher(@Param("id") int id);
}
