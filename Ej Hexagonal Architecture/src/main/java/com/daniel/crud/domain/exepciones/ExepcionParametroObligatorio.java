package com.daniel.crud.domain.exepciones;

public class ExepcionParametroObligatorio extends RuntimeException{

    public ExepcionParametroObligatorio(String msj){
        super(msj);
    }
}
