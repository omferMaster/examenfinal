package com.examenFinal.webProject.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tienda")
public class tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    @Column(nullable = false, unique = true)
    private UUID uuid;

        public tienda() {}

        public tienda(Long id, String nombre, String direccion, UUID uuid) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
            this.uuid = uuid;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public String getDireccion() {
            return direccion;
        }
    
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    
        public UUID getUuid() {
            return uuid;
        }
    
        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }
    }