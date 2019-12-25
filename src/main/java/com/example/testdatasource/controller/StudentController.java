package com.example.testdatasource.controller;

import com.example.testdatasource.pojo.Student;
import com.example.testdatasource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService sService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Student get(@RequestParam("id")String id){
        return sService.getStudent(id);
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public List<Student> getList(){
        return sService.getList();
    }
}
