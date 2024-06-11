package com.daniel.prueba.dominio;

public class Revista extends Recurso{
    public Revista(String nombre,  String codigo, boolean prestado) {
        super(nombre, prestado, codigo);
    }
}
