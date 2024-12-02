package com.examenFinal.webProject.dao;

import com.examenFinal.webProject.entity.compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface compraDao extends JpaRepository<compra, Long> {

    // Encuentra todas las compras de un cliente específico
    List<compra> findByClienteId(Long clienteId);

    // Encuentra compras realizadas en una tienda específica
    List<compra> findByTiendaId(Long tiendaId);

    // Encuentra compras cuyo total supere un monto específico
    List<compra> findByTotalGreaterThan(BigDecimal monto);

    // Encuentra compras realizadas entre dos fechas específicas
    List<compra> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Encuentra las compras que incluyan observaciones no nulas
    List<compra> findByObservacionesIsNotNull();

    // Consulta personalizada: suma total de ventas en un rango de fechas
    @Query("SELECT SUM(c.total) FROM compra c WHERE c.fecha BETWEEN :fechaInicio AND :fechaFin")
    BigDecimal findTotalVentasByFecha(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                      @Param("fechaFin") LocalDateTime fechaFin);

    // Consulta personalizada: obtiene las compras con impuestos mayores a un valor dado
    @Query("SELECT c FROM Compra c WHERE c.impuestos > :impuestosMinimos")
    List<compra> findComprasConImpuestosAltos(@Param("impuestosMinimos") BigDecimal impuestosMinimos);

    // Encuentra las compras realizadas por un cliente en una tienda específica
    List<compra> findByClienteIdAndTiendaId(Long clienteId, Long tiendaId);

    // Encuentra las compras realizadas por un cajero específico
    List<compra> findByCajeroId(Long cajeroId);

    // Encuentra las compras realizadas por un vendedor específico
    List<compra> findByVendedorId(Long vendedorId);
}
