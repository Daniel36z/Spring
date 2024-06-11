package com.daniel.prueba.dominio;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
public class Biblioteca {

    ArrayList<Recurso> recursos = new ArrayList<>();
    @RequestMapping(value = "/biblioteca/{nombre}/{tipo}/{codigo}")
    public ResponseEntity<String> agregarRecurso(@PathVariable ("nombre") String nombre,
                                                 @PathVariable ("tipo") int tipo,
                                                 @PathVariable("codigo") String codigo) {

        Recurso tipoRecurso = null;

        //se debe usar getters para buscar en la lista con spring
        for(Recurso recursobuscado : recursos){
            if(Objects.equals(recursobuscado.getCodigo(), codigo)){
                return new ResponseEntity<>("Este recurso ya esta en la DB", HttpStatus.BAD_REQUEST);
            }
        }

        if(tipo == 1){
            tipoRecurso = new Libro(nombre,codigo,false);

        }
        else if (tipo == 2){
            tipoRecurso = new Tesis(nombre,codigo,false);

        }
        else if (tipo == 3){
            tipoRecurso = new Revista(nombre,codigo,false);

        }

        recursos.add(tipoRecurso);
        return new ResponseEntity<>("recurso agregado", HttpStatus.OK);
    }

    @GetMapping(value = "/lista")
    public List<Recurso> listarRecursos(){
        return recursos;
    }
}
