package com.daniel.prueba.dominio;

public class Tesis extends Recurso implements Copiable{


    public Tesis(String nombre, String codigo, int tipoRecurso) {
        super(nombre, codigo, tipoRecurso);
    }

    @Override
    public void copiar() {
        this.nroCopias ++;
    }
}
