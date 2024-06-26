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

    @PostMapping("/biblioteca/agregar")  //como se instancia de Recurso este no dene ser abtracto
    public ResponseEntity<String> agregarRecurso(@RequestBody Recurso recursoEntrante) {

        Recurso tipoRecurso = null;


        //se debe usar getters para buscar en la lista con spring
        for(Recurso recursobuscado : recursos){
            if(Objects.equals(recursobuscado.getCodigo(), recursoEntrante.getCodigo())){
                return new ResponseEntity<>("Este recurso ya esta en la DB", HttpStatus.BAD_REQUEST);
            }
        }

        if(recursoEntrante.getTipoRecurso() == 1){
            tipoRecurso = new Libro(recursoEntrante.nombre,recursoEntrante.getCodigo(),
                    recursoEntrante.getTipoRecurso());
        }
        else if(recursoEntrante.getTipoRecurso() == 2){
            tipoRecurso = new Revista(recursoEntrante.nombre,recursoEntrante.getCodigo(),
                    recursoEntrante.getTipoRecurso());
        }
        else if(recursoEntrante.getTipoRecurso() == 3){
            tipoRecurso = new Tesis(recursoEntrante.nombre,recursoEntrante.getCodigo(),
                    recursoEntrante.getTipoRecurso());
        }

        recursos.add(tipoRecurso);
        return new ResponseEntity<>("Recurso agregado", HttpStatus.OK);
    }

    @GetMapping("/biblioteca/consultar")
    public List<Recurso> listarRecursos(){

        return recursos;
    }

    @PostMapping("/biblioteca/prestar/{codigo}")
    public ResponseEntity<String > prestar(@PathVariable("codigo") String codigo){

        for (Recurso recursoBuscado: recursos){

            if(Objects.equals(recursoBuscado.getCodigo(), codigo)){
                if(recursoBuscado instanceof Tesis){
                    return new ResponseEntity<>("Este recurso no se presta", HttpStatus.NOT_ACCEPTABLE);
                }
                else if (recursoBuscado.prestado) {
                    return new ResponseEntity<>("Ya esta prestado este recurso", HttpStatus.NOT_ACCEPTABLE);
                }
                else if (recursoBuscado instanceof Prestable) {
                    ((Prestable) recursoBuscado).prestar();
                    return new ResponseEntity<>("Ok todo en orden", HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>("Ups!! Algo ha salido mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/biblioteca/devolver/{codigo}")
    public ResponseEntity<String > devolver(@PathVariable("codigo") String codigo){

        for (Recurso recursoBuscado: recursos){

            if(Objects.equals(recursoBuscado.getCodigo(), codigo)){
                if(recursoBuscado instanceof Tesis){
                    return new ResponseEntity<>("Este recurso no se presta", HttpStatus.NOT_ACCEPTABLE);
                }
                else if (!recursoBuscado.prestado) {
                    return new ResponseEntity<>("Este recurso no se ha prestado", HttpStatus.NOT_ACCEPTABLE);
                }
                else if (recursoBuscado instanceof Prestable) {
                    ((Prestable) recursoBuscado).devolver();
                    return new ResponseEntity<>("Ok todo en orden", HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>("¡Algo ha salido mal!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/biblioteca/fotocopiar/{codigo}")
    public ResponseEntity<String> fotocopiar(@PathVariable("codigo") String codigo){
        for(Recurso recursoBuscado: recursos){
            if(Objects.equals(recursoBuscado.getCodigo(), codigo)){
                if(recursoBuscado instanceof Revista){
                    return new ResponseEntity<>("Este recurso no se pued duplicar", HttpStatus.BAD_REQUEST);
                }
                else if (recursoBuscado instanceof Copiable) {
                    ((Copiable) recursoBuscado).copiar();
                    return new ResponseEntity<>("Ok se ha generado una copia", HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>("¡Algo ha salido mal!", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/biblioteca/prestados")
    public List<Recurso> listarPrestados(){
        return  this.recursos.stream().filter(i->i.prestado).toList();
    }

    @GetMapping("/biblioteca/copiados")
    public List<Recurso> listarCopias(){
        return  this.recursos.stream().filter(i->i.nroCopias>0).toList();
    }

}
