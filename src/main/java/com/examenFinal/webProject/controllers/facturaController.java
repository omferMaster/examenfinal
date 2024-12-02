package com.examenFinal.webProject.controllers;

import com.examenFinal.webProject.entity.*;
import com.examenFinal.webProject.service.facturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/factura")
public class facturaController {

    @Autowired
    private facturaService facturaService;

    @PostMapping("/crear/{tiendaUuid}")
    public ResponseEntity<?> crearFactura(
            @PathVariable String tiendaUuid,
            @RequestBody compra compra) {
        try {
            // Convertir el UUID de la tienda
            UUID uuid = UUID.fromString(tiendaUuid);

            // Procesar la factura
            compra facturaGuardada = facturaService.procesarFactura(uuid, compra);

            // Devolver la factura registrada
            return ResponseEntity.ok(facturaGuardada);
        } catch (IllegalArgumentException ex) {
            // Manejar errores como tienda no encontrada
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            // Manejar otros errores
            return ResponseEntity.internalServerError().body("Ocurrió un error al procesar la factura.");
        }
    }
}

