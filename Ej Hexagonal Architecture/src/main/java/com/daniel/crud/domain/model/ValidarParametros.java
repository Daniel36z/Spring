package com.daniel.crud.domain.model;

import com.daniel.crud.domain.exepciones.ExepcionParametroObligatorio;

public class ValidarParametros {

    public static void validacionObligatoria(String parametro, String msj){
        if(parametro.isEmpty()){
            throw new ExepcionParametroObligatorio(msj);
        }
    }
}
