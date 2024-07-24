package com.daniel.crud.domain.dto;


//patron de diseño DTO
public class  DtoUser {
    private String nameUser;
    private String correoElectronico;

    public DtoUser(String nameUser, String correoElectronico) {
        this.nameUser = nameUser;
        this.correoElectronico = correoElectronico;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
