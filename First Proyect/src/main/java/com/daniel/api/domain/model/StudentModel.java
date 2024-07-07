package com.daniel.api.domain.model;

import java.time.LocalDate;

public class StudentModel {

    private Long id;
    private String name;
    private LocalDate dob;
    private Integer age;
    private String email;

    public StudentModel(String name, LocalDate dob, Integer age,String email) {
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
