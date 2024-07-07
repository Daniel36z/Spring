package com.daniel.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Haber2 {

    @Autowired
    private final c2 cc;

    public Haber2(c2 cc) {
        this.cc = cc;
    }

}
