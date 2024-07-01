package com.daniel.crud.repository;

import com.daniel.crud.model.libraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface libraryRepository extends JpaRepository<libraryModel, Long> {

}
