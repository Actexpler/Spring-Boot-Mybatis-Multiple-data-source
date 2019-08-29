package com.example.ssm.controller;

import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.service.TaskMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;

@RestController
public class studentController {
    @Autowired
    private StudentService sService;

    @RequestMapping(value = "/getStudent")
    public Student getStudent(@RequestParam("Id")int id){

        Timer timer = new Timer("TestTime");
        TaskMonitor taskMonitor = new TaskMonitor();
        timer.scheduleAtFixedRate(taskMonitor,0, 10000);
        return null;
    }
    @RequestMapping(value = "/getStudent2")
    public Student getStudent2(@RequestParam("Id")int id){
        return sService.getStudent(id);
    }
}
