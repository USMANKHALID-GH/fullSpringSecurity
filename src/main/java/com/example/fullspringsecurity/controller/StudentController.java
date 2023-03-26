package com.example.fullspringsecurity.controller;

import com.example.fullspringsecurity.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {


    @GetMapping("/")
    public  String hello(){
        return "secured";
    }


    @PostMapping("/")
    public Student save(@RequestBody Student student) {
        return  student;

    }

    @DeleteMapping("/")
    public List<Student> studentList(){
     List<Student> student=new ArrayList<>();
        IntStream.range(1,40)
                .forEach(i->student.add(new Student(i,"usman","khalid",10+i)));
        return student;

    }


}
