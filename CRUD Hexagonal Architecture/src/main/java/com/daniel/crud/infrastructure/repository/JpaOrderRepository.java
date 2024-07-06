package com.daniel.crud.infrastructure.repository;

import com.daniel.crud.domain.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrdenModel,Long> {
}
