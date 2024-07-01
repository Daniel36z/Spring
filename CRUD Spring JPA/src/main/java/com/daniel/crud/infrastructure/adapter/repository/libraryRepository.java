package com.daniel.crud.infrastructure.adapter.repository;

import com.daniel.crud.infrastructure.adapter.entity.libraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface libraryRepository extends JpaRepository<libraryModel, Long> {

}
