package com.daniel.prueba.dominio;

public abstract class Recurso {
    protected String nombre;
    protected String codigo;
    protected boolean prestado;
    protected int nroCopias;


    public Recurso(String nombre, boolean prestado, String codigo) {
        this.nombre = nombre;
        this.prestado = prestado;
        this.codigo = codigo;
    }

    //si bien los atributos on protected y son accesibles para las clases y metodos
    //para serializarlos y devoloverlos en endpoint spring necesita getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public int getNroCopias() {
        return nroCopias;
    }

    public void setNroCopias(int nroCopias) {
        this.nroCopias = nroCopias;
    }






}
