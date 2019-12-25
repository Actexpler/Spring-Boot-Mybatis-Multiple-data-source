package com.example.testdatasource.controller;

import com.example.testdatasource.pojo.Teacher;
import com.example.testdatasource.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService tService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Teacher getTeacher(@RequestParam("id")String id){
        return tService.getTeacher(id);
    }
}
