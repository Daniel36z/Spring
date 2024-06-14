package com.daniel.prueba.dominio;

public class Libro extends Recurso implements Copiable , Prestable{

    public Libro(String nombre, String codigo, int tipoRecurso) {
        super(nombre, codigo, tipoRecurso);
    }

    @Override
    public void copiar() {
        this.nroCopias ++;
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
