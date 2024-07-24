package com.daniel.crud.domain.model;


import static com.daniel.crud.domain.model.ValidarParametros.validacionObligatoria;

public class UserModel {

    private static final String MENSAJE_CORREO_OBLIGATORIO = "El correo electrónico es obligatorio.";
    private static final String MENSAJE_NAME_OBLIGATORIO = "El nombre electrónico es obligatorio.";


    private String nameUser;
    private String correoElectronico;
    private boolean apto;


    //cuando se necesite cdrea el objeto hace validaciones obligatorias
    public UserModel(String nameUser, String correoElectronico, boolean apto) {
        validacionObligatoria(nameUser,MENSAJE_NAME_OBLIGATORIO);
        validacionObligatoria(correoElectronico,MENSAJE_CORREO_OBLIGATORIO);
        this.nameUser = nameUser;
        this.correoElectronico = correoElectronico;
        this.apto = apto;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public boolean isApto() {
        return apto;
    }
}
