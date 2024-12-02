package com.examenFinal.webProject.service;

import com.examenFinal.webProject.entity.*;
import com.examenFinal.webProject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class tiendaService {

    @Autowired
    private tiendaDao tiendaDao;

    @Autowired
    private compraDao compraDao;

    public Optional<tienda> findTiendaByUuid(UUID uuid) {
        return tiendaDao.findByUuid(uuid);
    }

    public compra registrarCompra(UUID tiendaUuid, compra compra) {
        // Buscar la tienda por UUID
        Optional<tienda> tiendaOptional = tiendaDao.findByUuid(tiendaUuid);
        if (tiendaOptional.isEmpty()) {
            throw new IllegalArgumentException("La tienda con UUID " + tiendaUuid + " no existe.");
        }

        // Asignar la tienda a la compra
        tienda tienda = tiendaOptional.get();
        compra.setTienda(tienda);

        // Guardar la compra
        return compraDao.save(compra);
    }
}
