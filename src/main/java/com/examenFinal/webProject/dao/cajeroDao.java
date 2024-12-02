package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface cajeroDao extends JpaRepository<cajero, Long> {

    // Encuentra un cajero por su ID
    Optional<cajero> findById(Long id);

    // Encuentra todos los cajeros
    List<cajero> findAll();

    // Encuentra cajeros por su nombre
    List<cajero> findByNombre(String nombre);

    // Encuentra cajeros por tienda
    List<cajero> findByTiendaId(String tiendaId);

    // Consulta personalizada para obtener el total de ventas realizadas por un cajero
    @Query("SELECT SUM(f.total) FROM Factura f WHERE f.cajero.id = ?1")
    Double findTotalVentasPorCajero(Long cajeroId);

    // Consulta personalizada para obtener el cajero con más ventas
    @Query("SELECT c FROM Cajero c WHERE c.id = (SELECT f.cajero.id FROM Factura f GROUP BY f.cajero.id ORDER BY SUM(f.total) DESC LIMIT 1)")
    cajero findCajeroConMasVentas();
}
