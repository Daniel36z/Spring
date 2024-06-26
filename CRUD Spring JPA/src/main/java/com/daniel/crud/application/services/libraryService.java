package com.daniel.crud.application.services;

import com.daniel.crud.infrastructure.adapter.entity.libraryModel;
import com.daniel.crud.infrastructure.adapter.repository.libraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class libraryService {
    @Autowired
    libraryRepository libraryRepository;

    public List<libraryModel> getLibros(){
    return libraryRepository.findAll();
    }

    public Optional<libraryModel> buscarLibro(Long id){
        return libraryRepository.findById(id);
    }

    public void saveBook(libraryModel book){
        libraryRepository.save(book);
    }
}
