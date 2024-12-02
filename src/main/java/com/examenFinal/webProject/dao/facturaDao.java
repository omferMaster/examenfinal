package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface facturaDao extends JpaRepository<factura, Long> {
    // Consulta personalizada para obtener todas las facturas de un cliente específico
    List<factura> findByClienteId(Long clienteId);

    // Consulta personalizada para obtener todas las facturas de una tienda específica
    List<factura> findByTiendaId(String tiendaId);

    // Consulta personalizada para obtener las facturas de un vendedor específico
    List<factura> findByVendedorId(Long vendedorId);

    // Consulta personalizada para obtener las facturas de un cajero específico
    List<factura> findByCajeroId(Long cajeroId);

    // Consulta personalizada para obtener las facturas por fecha
    @Query("SELECT f FROM Factura f WHERE f.fecha BETWEEN ?1 AND ?2")
    List<factura> findFacturasByFechaBetween(java.util.Date startDate, java.util.Date endDate);

    // Consulta personalizada para obtener el total de facturación por tienda
    @Query("SELECT SUM(f.total) FROM Factura f WHERE f.tienda.id = ?1")
    Double findTotalFacturacionPorTienda(String tiendaId);
}
