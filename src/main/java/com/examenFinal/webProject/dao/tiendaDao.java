package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface tiendaDao extends JpaRepository<tienda, Long> {

    // Encuentra una tienda por su ID
    Optional<tienda> findById(String id);

    // Encuentra todas las tiendas
    List<tienda> findAll();

    // Consulta personalizada para obtener todas las tiendas con un nombre específico
    List<tienda> findByNombre(String nombre);

    // Consulta personalizada para obtener todas las tiendas por ciudad
    List<tienda> findByCiudad(String ciudad);

    // Consulta personalizada para obtener el total de ventas realizadas por tienda
    @Query("SELECT SUM(f.total) FROM Factura f WHERE f.tienda.id = ?1")
    Double findTotalVentasPorTienda(String tiendaId);

    // Consulta para obtener la tienda con más facturación
    @Query("SELECT t FROM Tienda t WHERE t.id = (SELECT f.tienda.id FROM Factura f GROUP BY f.tienda.id ORDER BY SUM(f.total) DESC LIMIT 1)")
    tienda findTiendaConMayorFacturacion();
}
