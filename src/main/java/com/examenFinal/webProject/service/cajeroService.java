package com.examenFinal.webProject.service;

import com.examenFinal.webProject.dao.*;
import com.examenFinal.webProject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cajeroService {

    @Autowired
    private cajeroDao cajeroDao;

    // Crear un nuevo cajero
    public cajero crearCajero(cajero cajero) {
        return cajeroDao.save(cajero);
    }

    // Obtener un cajero por su ID
    public Optional<cajero> obtenerCajeroPorId(Long id) {
        return cajeroDao.findById(id);
    }

    // Obtener todos los cajeros
    public List<cajero> obtenerTodosLosCajeros() {
        return cajeroDao.findAll();
    }

    // Obtener cajeros por nombre
    public List<cajero> obtenerCajerosPorNombre(String nombre) {
        return cajeroDao.findByNombre(nombre);
    }

    // Obtener cajeros por tienda
    public List<cajero> obtenerCajerosPorTienda(String tiendaId) {
        return cajeroDao.findByTiendaId(tiendaId);
    }

    // Obtener el total de ventas realizadas por un cajero
    public Double obtenerTotalVentasPorCajero(Long cajeroId) {
        return cajeroDao.findTotalVentasPorCajero(cajeroId);
    }

    // Obtener el cajero con más ventas
    public cajero obtenerCajeroConMasVentas() {
        return cajeroDao.findCajeroConMasVentas();
    }
}
