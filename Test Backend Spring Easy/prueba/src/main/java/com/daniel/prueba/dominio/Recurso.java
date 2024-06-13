package com.daniel.prueba.dominio;

public class Recurso {
    protected String nombre;
    protected String codigo;
    protected int nroCopias;
    protected boolean prestado;
    protected  int tipoRecurso;

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public Recurso(String nombre, String codigo, int tipoRecurso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipoRecurso = tipoRecurso;
    }

    public int getNroCopias() {
        return nroCopias;
    }

    public void setNroCopias(int nroCopias) {
        this.nroCopias = nroCopias;
    }

    public int getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(int tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
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
