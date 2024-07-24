package com.daniel.crud.domain.exepciones;

public class UsuarioExisteExeption extends RuntimeException{
   public UsuarioExisteExeption(String msj){
        super(msj);
    }
}
