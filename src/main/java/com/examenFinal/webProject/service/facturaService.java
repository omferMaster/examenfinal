package com.examenFinal.webProject.service;

import com.examenFinal.webProject.entity.*;
import com.examenFinal.webProject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class facturaService {

    @Autowired
    private compraDao compraDao;

    @Autowired
    private tiendaDao tiendaDao;

    public compra procesarFactura(UUID tiendaUuid, compra compra) throws IllegalArgumentException {
        // Buscar tienda por UUID
        Optional<tienda> tiendaOptional = tiendaDao.findByUuid(tiendaUuid);
        if (tiendaOptional.isEmpty()) {
            throw new IllegalArgumentException("La tienda con UUID " + tiendaUuid + " no existe.");
        }

        // Asignar la tienda encontrada a la compra
        tienda tienda = tiendaOptional.get();
        compra.setTienda(tienda);

        // Guardar la compra en la base de datos
        return compraDao.save(compra);
    }
}
