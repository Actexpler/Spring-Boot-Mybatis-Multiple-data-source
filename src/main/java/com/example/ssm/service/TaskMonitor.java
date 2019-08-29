package com.example.ssm.service;

import com.example.ssm.mapper.student.studentMapper;
import com.example.ssm.pojo.Student;
import com.example.ssm.pojo.Teacher;
import com.example.ssm.util.SpringContextUtil;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.TimerTask;

public class TaskMonitor extends TimerTask {

    private int id = 111;
//    @Autowired
//    private StudentService sService;
//    ApplicationContext appCtx = (ApplicationContext) SpringContextUtil.getApplicationContext();
    private StudentService studentService = (StudentService) SpringContextUtil.getBean(StudentService.class);
    private TeacherService tService = (TeacherService) SpringContextUtil.getBean(TeacherService.class);
    private static int count = 0;

    public static TaskMonitor taskMonitor;

//    @PostConstruct
//    public void init(){
//        taskMonitor = this;
//        taskMonitor.sService = this.sService;
//    }

//    public TaskMonitor(int id){
//        this.id = id;
//    }

    @Override
    public void run() {
//        Student student = studentService.getStudent(this.id);
//        System.out.println(student);
        Teacher teacher = tService.getTeacher(this.id);
        System.out.println(teacher);
        count++;
        if(count >= 3) {
//            taskMonitor.cancel();
            this.cancel();
        }

    }

}
