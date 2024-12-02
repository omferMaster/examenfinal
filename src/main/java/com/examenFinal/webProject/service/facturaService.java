package com.examenFinal.webProject.service;

import com.examenFinal.webProject.dao.*;
import com.examenFinal.webProject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class facturaService {

    @Autowired
    private facturaDao facturaDao;

    @Autowired
    private clienteDao clienteDao;

    @Autowired
    private tiendaDao tiendaDao;

    @Autowired
    private vendedorDao vendedorDao;

    @Autowired
    private cajeroDao cajeroDao;

    public factura crearFactura(String tiendaId, Long clienteId, Long vendedorId, Long cajeroId, BigDecimal total) {
        // Buscar la tienda, cliente, vendedor y cajero por sus IDs
        tienda tienda = tiendaDao.findById(tiendaId).orElseThrow(() -> new IllegalArgumentException("Tienda no encontrada"));
        cliente cliente = clienteDao.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        vendedor vendedor = vendedorDao.findById(vendedorId).orElseThrow(() -> new IllegalArgumentException("Vendedor no encontrado"));
        cajero cajero = cajeroDao.findById(cajeroId).orElseThrow(() -> new IllegalArgumentException("Cajero no encontrado"));

        // Crear la nueva factura
        factura factura = new factura();
        factura.setFecha(new Date());
        factura.setTotal(total);
        factura.setTienda(tienda);
        factura.setCliente(cliente);
        factura.setVendedor(vendedor);
        factura.setCajero(cajero);

        // Guardar la factura en la base de datos
        return facturaDao.save(factura);
    }
}
