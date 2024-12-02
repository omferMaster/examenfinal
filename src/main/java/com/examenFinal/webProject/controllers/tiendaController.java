package com.examenFinal.webProject.controllers;

import com.examenFinal.webProject.entity.*;
import com.examenFinal.webProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tienda")
public class tiendaController {

    @Autowired
    private tiendaService tiendaService;

    // Endpoint para registrar una compra asociada a una tienda
    @PostMapping("/crear/{tiendaUuid}")
    public ResponseEntity<?> registrarCompra(
            @PathVariable String tiendaUuid,
            @RequestBody compra compra) {
        try {
            // Convertir UUID a tipo UUID
            UUID uuid = UUID.fromString(tiendaUuid);

            // Registrar la compra
            compra compraRegistrada = tiendaService.registrarCompra(uuid, compra);

            // Devolver respuesta exitosa
            return ResponseEntity.ok(compraRegistrada);
        } catch (IllegalArgumentException e) {
            // Manejar errores de validación
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.internalServerError().body("Error al registrar la compra.");
        }
    }
}
