package com.daniel.prueba.dominio;

public class Revista extends Recurso implements Prestable{


    public Revista(String nombre, String codigo, int tipoRecurso) {
        super(nombre, codigo, tipoRecurso);
    }

    @Override
    public void prestar() {
        this.setPrestado(true);
    }

    @Override
    public void devolver() {
        this.setPrestado(false);
    }
}
