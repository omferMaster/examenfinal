package com.examenFinal.webProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cajero")
public class cajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String documento;

    private String email;

    private String token;

    @ManyToOne
    @JoinColumn(name = "tienda_id", nullable = false)
    private tienda tienda;

    // Getters y setters
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public tienda getTienda() {
        return tienda;
    }

    public void setTienda(tienda tienda) {
        this.tienda = tienda;
    }
}
