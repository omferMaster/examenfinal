package com.examenFinal.webProject.service;

import com.examenFinal.webProject.dao.*;
import com.examenFinal.webProject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class vendedorService {

    @Autowired
    private vendedorDao vendedorDao;

    // Crear un nuevo vendedor
    public vendedor crearVendedor(vendedor vendedor) {
        return vendedorDao.save(vendedor);
    }

    // Obtener un vendedor por su ID
    public Optional<vendedor> obtenerVendedorPorId(Long id) {
        return vendedorDao.findById(id);
    }

    // Obtener todos los vendedores
    public List<vendedor> obtenerTodosLosVendedores() {
        return vendedorDao.findAll();
    }

    // Obtener vendedores por nombre
    public List<vendedor> obtenerVendedoresPorNombre(String nombre) {
        return vendedorDao.findByNombre(nombre);
    }

    // Obtener vendedores por tienda
    public List<vendedor> obtenerVendedoresPorTienda(String tiendaId) {
        return vendedorDao.findByTiendaId(tiendaId);
    }

    // Obtener total de ventas por vendedor
    public Double obtenerTotalVentasPorVendedor(Long vendedorId) {
        return vendedorDao.findTotalVentasPorVendedor(vendedorId);
    }

    // Obtener el vendedor con más ventas
    public vendedor obtenerVendedorConMasVentas() {
        return vendedorDao.findVendedorConMasVentas();
    }
}
