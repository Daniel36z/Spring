package com.daniel.prueba1.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
//busca las configuraciones que comiencen con storage
//y los vincula al campo correspondiente en esta clase
public class StorageProperties {
    private String location = "C:\\Users\\Daniel\\Desktop\\archivosSpring";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
