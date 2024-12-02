package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.tienda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface tiendaDao extends JpaRepository<tienda, Long> {
    Optional<tienda> findByUuid(UUID uuid);
}
