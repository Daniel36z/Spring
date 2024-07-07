package com.daniel.api.domain.ports;

import com.daniel.api.domain.model.StudentModel;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    StudentModel getStudent();
}
