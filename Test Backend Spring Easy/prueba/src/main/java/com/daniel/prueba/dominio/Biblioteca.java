package com.daniel.prueba.dominio;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
//@RequestMapping("/biblioteca")
public class Biblioteca {

    ArrayList<Recurso> recursos = new ArrayList<>();

    @PostMapping("/biblioteca/v1")  //como se instancia de Recurso este no dene ser abtracto
    public ResponseEntity<String> agregarRecurso(@RequestBody Recurso recursoEntrante) {

        Recurso tipoRecurso = null;


        //se debe usar getters para buscar en la lista con spring
        for(Recurso recursobuscado : recursos){
            if(Objects.equals(recursobuscado.getCodigo(), recursoEntrante.getCodigo())){
                return new ResponseEntity<>("Este recurso ya esta en la DB", HttpStatus.BAD_REQUEST);
            }
        }

        if(recursoEntrante.getTipo() == 1){
            tipoRecurso = new Libro(recursoEntrante.nombre,recursoEntrante.getCodigo(),
                    recursoEntrante.getTipo());
        }



        recursos.add(tipoRecurso);
        return new ResponseEntity<>("codigo: " + recursoEntrante.getCodigo(), HttpStatus.OK);
    }

    @GetMapping("/biblioteca/v2")
    public List<Recurso> listarRecursos(){

        return recursos;
    }
}
