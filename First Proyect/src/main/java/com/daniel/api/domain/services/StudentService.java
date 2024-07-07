package com.daniel.api.domain.services;

import com.daniel.api.domain.model.StudentModel;
import com.daniel.api.domain.ports.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class StudentService implements StudentRepository {

    @Override
    public StudentModel getStudent() {
        return new StudentModel(
                "daniel",
                LocalDate.of(2000, Month.MARCH,24),
                25,
                "dan@gmail.com"
        );
    }
}
