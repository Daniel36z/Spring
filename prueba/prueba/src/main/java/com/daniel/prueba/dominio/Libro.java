package com.daniel.prueba.dominio;

public class Libro extends Recurso{
    public Libro(String nombre,String codigo, boolean prestado) {
        super(nombre, prestado, codigo);
    }
}
