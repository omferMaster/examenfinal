package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface vendedorDao extends JpaRepository<vendedor, Long> {

    // Encuentra un vendedor por su ID
    Optional<vendedor> findById(Long id);

    // Encuentra todos los vendedores
    List<vendedor> findAll();

    // Encuentra vendedores por su nombre
    List<vendedor> findByNombre(String nombre);

    // Encuentra vendedores por su tienda
    List<vendedor> findByTiendaId(String tiendaId);

    // Consulta personalizada para obtener el total de ventas realizadas por un vendedor
    @Query("SELECT SUM(f.total) FROM Factura f WHERE f.vendedor.id = ?1")
    Double findTotalVentasPorVendedor(Long vendedorId);

    // Consulta personalizada para obtener el vendedor con más ventas
    @Query("SELECT v FROM Vendedor v WHERE v.id = (SELECT f.vendedor.id FROM Factura f GROUP BY f.vendedor.id ORDER BY SUM(f.total) DESC LIMIT 1)")
    vendedor findVendedorConMasVentas();
}
