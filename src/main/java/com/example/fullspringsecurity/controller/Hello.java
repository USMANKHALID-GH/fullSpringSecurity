package com.example.fullspringsecurity.controller;


import com.example.fullspringsecurity.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/any")
public class Hello {




    @GetMapping("/")
    public  String hello(){
        return "Hello world";
    }
    @GetMapping("/{i}")
    public  String hello1(@PathVariable("i") String i){
        return "Hello world"+i;
    }


}
