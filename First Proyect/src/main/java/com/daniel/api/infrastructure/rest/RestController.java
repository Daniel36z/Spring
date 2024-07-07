package com.daniel.api.infrastructure.rest;

import com.daniel.api.application.services.StudentComponent;
import com.daniel.api.domain.model.StudentModel;
import com.daniel.api.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;

@org.springframework.web.bind.annotation.RestController
public class RestController {



    @Autowired
    private final StudentComponent studentComponent;

    public RestController(StudentComponent studentComponent) {
        this.studentComponent = studentComponent;
    }


    @GetMapping("/student")
    public StudentModel saludo(){
       return studentComponent.getStudentCheck();
    }


}
