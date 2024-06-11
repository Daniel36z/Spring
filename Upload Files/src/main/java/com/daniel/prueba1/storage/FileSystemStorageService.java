package com.daniel.prueba1.storage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    //Path de tipo rutas de archivo
    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {//properties es str

        if(properties.getLocation().trim().length() == 0){
            throw new StorageException("Oiga esa ruta esta void");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    //multipart es para manejar archivos que provienen de un html form
    public void store(MultipartFile file){ //aqui
        try{
            if(file.isEmpty()){
                throw new StorageException("No puedes subir un archivo vacio :9");
            }

            Path destinationFile = this.rootLocation.resolve(
           Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
            //Une ruta de la carpeta con el nombre del archivo

            //las rutas de almacenaje deben ser iguales
            if(!destinationFile.getParent().equals (this.rootLocation.toAbsolutePath())){
                throw new StorageException("No se puede almacenararchivos fuera del " +
                        "destino raiz");
            }

            //un inputstream almacena datos byte a byte/ getinputstream permoite
            //getinputstream crea un flujo de entrada que permirte leer los
            // datos dentro del archivo
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream,destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }

        }
        catch(IOException e){
            throw new StorageException("Hubo un problema subiendo el archivo",e);
        }

    }

    @Override
    public Stream<Path> loadAll(){
        try {
            //walk recorre todas las rutas y entrega solo la primera
            return Files.walk(this.rootLocation,1)
                    .filter(path ->!path.equals(this.rootLocation))
                            .map(this.rootLocation::relativize);
        }

        catch (IOException e){
            throw new RuntimeException("No se pudieron leer los archivos almacenados",e);
        }

    }


    //concatena el nombre del archivo con la ruta de ubicacion
    @Override
    public Path load(String filename){
        return rootLocation.resolve(filename);
    }

    //Resource almacena datos oarchivos como imagenes, docs, audios
    @Override
    public Resource loadAsResource(String filename){
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            //retorna true y true si existe dicho archivo y se puede leer sin permisos
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else{
                throw new StorageException("No se pueden leer el archivo: " + filename);
            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename,e);
        }

    }

    @Override
    public void deleteAll() {
        //Recibe por parametro un tipo file
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
        System.out.println("se han borrado los datos");
    }


    //@Override
    public void init(){
        System.out.println("crear repo");
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("No se puedo crear el directorio de almacenamiento",e);
        }
    }

}
