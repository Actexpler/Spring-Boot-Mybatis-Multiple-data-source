package com.example.ssm.controller;

import com.example.ssm.pojo.Teacher;
import com.example.ssm.service.TaskMonitor;
import com.example.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;

@RestController
public class teacherController {
    @Autowired
    private TeacherService tService;

    @RequestMapping(value = "/getTeacher")
    public Teacher getTeacher(@RequestParam("Id")int id){
        Timer timer = new Timer("TestTime");
        TaskMonitor taskMonitor = new TaskMonitor();
        timer.scheduleAtFixedRate(taskMonitor,0, 10000);
        return null;
    }
    @RequestMapping(value = "/getTeacher2")
    public Teacher getTeacher2(@RequestParam("Id")int id){
        System.out.println("controller");
        return tService.getTeacher(id);
    }
}
