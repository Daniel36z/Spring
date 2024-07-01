package com.daniel.crud.infrastructure.rest.controller;

import com.daniel.crud.infrastructure.adapter.entity.libraryModel;
import com.daniel.crud.application.services.libraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class libraryController {

    @Autowired
    final libraryService libraryService;

    public libraryController(com.daniel.crud.application.services.libraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping("biblioteca/listar")
    public List<libraryModel> listarLibros(){
        return libraryService.getLibros();
    }


    @PostMapping("biblioteca/guardar")
    public void guardarLibro(@RequestBody libraryModel libraryModel){
        System.out.println(libraryModel.getBookName());
        libraryService.saveBook(libraryModel);
    }
}
