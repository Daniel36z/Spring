package com.daniel.crud.controller;

import com.daniel.crud.model.libraryModel;
import com.daniel.crud.service.libraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class libraryController {

    @Autowired
    final libraryService libraryService;

    public libraryController(com.daniel.crud.service.libraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping("biblioteca/listar")
    public List<libraryModel> listarLibros(){
        return libraryService.getLibros();
    }


    @PostMapping("biblioteca/guardar")
    public void guardarLibro(@RequestBody libraryModel libraryModel){
        libraryService.saveBook(libraryModel);
    }
}
