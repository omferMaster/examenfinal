package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface clienteDao extends JpaRepository<cliente, Long> {

    // Consulta personalizada para obtener todos los clientes por tipo de documento
    List<cliente> findBytipoDocumento(tipoDocumento tipoDocumento);

    // Consulta personalizada para obtener un cliente por documento (usando SQL nativo)
    @Query("SELECT c FROM cliente c WHERE c.documento = ?1")
    Optional<cliente> findByDocumento(String documento);

    // Consulta personalizada para contar clientes por tipo de documento
    @Query("SELECT COUNT(c) FROM cliente c WHERE c.tipoDocumento = ?1")
    Long countBytipoDocumento(tipoDocumento tipoDocumento);

    // Consulta personalizada con SQL nativo para obtener clientes por documento
    @Query(value = "SELECT * FROM cliente c WHERE c.documento = ?1", nativeQuery = true)
    Optional<cliente> findclienteByDocumento(String documento);

}
