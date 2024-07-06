package com.daniel.crud.infrastructure.adapters.repository;

import com.daniel.crud.domain.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrdenModel,Long> {
}
