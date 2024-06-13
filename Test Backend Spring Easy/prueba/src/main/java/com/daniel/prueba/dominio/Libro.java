package com.daniel.prueba.dominio;

public class Libro extends Recurso implements Copiable{

    public Libro(String nombre, String codigo, int tipoRecurso) {
        super(nombre, codigo, tipoRecurso);
    }

    @Override
    public void copiar() {
        this.nroCopias ++;
    }
}
