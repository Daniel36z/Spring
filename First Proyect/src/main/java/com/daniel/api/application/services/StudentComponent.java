package com.daniel.api.application.services;

import com.daniel.api.domain.model.StudentModel;
import com.daniel.api.domain.ports.StudentRepository;
import com.daniel.api.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentComponent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentModel getStudentCheck() {
       return studentRepository.getStudent();
    }
}
