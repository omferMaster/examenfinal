package com.examenFinal.webProject.controllers;

import com.examenFinal.webProject.entity.compra;
import com.examenFinal.webProject.service.compraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class compraController {

    @Autowired
    private compraService compraService;

    @GetMapping
    public List<compra> getAllCompras() {
        return compraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<compra> getCompraById(@PathVariable Long id) {
        compra compra = compraService.findById(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public compra createCompra(@RequestBody compra compra) {
        return compraService.save(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<compra> updateCompra(@PathVariable Long id, @RequestBody compra compraDetails) {
        compra compra = compraService.findById(id);
        if (compra != null) {
            compra.setTotal(compraDetails.getTotal());
            compra.setImpuestos(compraDetails.getImpuestos());
            compra.setFecha(compraDetails.getFecha());
            compra.setObservaciones(compraDetails.getObservaciones());
            // Actualiza otras propiedades según sea necesario
            return ResponseEntity.ok(compraService.save(compra));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id) {
        compraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
