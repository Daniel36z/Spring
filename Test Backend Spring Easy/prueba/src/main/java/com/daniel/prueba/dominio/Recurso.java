package com.daniel.prueba.dominio;

public class Recurso {
    protected String nombre;
    protected String codigo;
    protected int nroCopias;
    protected boolean prestado;
    protected  int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Recurso(String nombre, String codigo, int tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public int getNroCopias() {
        return nroCopias;
    }

    public void setNroCopias(int nroCopias) {
        this.nroCopias = nroCopias;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }


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


}
