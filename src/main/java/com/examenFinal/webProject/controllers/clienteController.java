package com.examenFinal.webProject.controllers;

import com.examenFinal.webProject.entity.*;
import com.examenFinal.webProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {

    @Autowired
    private clienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<cliente>> getAllclientes() {
        return ResponseEntity.ok(clienteService.getAllclientes());
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<cliente> getclienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getclienteById(id));
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<cliente> createcliente(@RequestBody cliente cliente) {
        return ResponseEntity.ok(clienteService.createcliente(cliente));
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<cliente> updatecliente(@PathVariable Long id, @RequestBody cliente cliente) {
        return ResponseEntity.ok(clienteService.updatecliente(id, cliente));
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecliente(@PathVariable Long id) {
        clienteService.deletecliente(id);
        return ResponseEntity.noContent().build();
    }
}
