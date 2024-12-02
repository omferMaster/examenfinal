package com.examenFinal.webProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "tipo_documento_id", nullable = false)
    private tipoDocumento tipoDocumento;

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

    public tipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(tipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
