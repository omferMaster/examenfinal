package com.examenFinal.webProject.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
public class compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tienda_id", nullable = false)
    private tienda tienda;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "cajero_id")
    private cajero cajero;

    private BigDecimal total;
    private BigDecimal impuestos;
    private LocalDateTime fecha;

    @Column(columnDefinition = "TEXT")
    private String observaciones;
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public cliente getCliente() {
            return cliente;
        }
    
        public void setCliente(cliente cliente) {
            this.cliente = cliente;
        }
    
        public tienda getTienda() {
            return tienda;
        }
    
        public void setTienda(tienda tienda) {
            this.tienda = tienda;
        }
    
        public vendedor getVendedor() {
            return vendedor;
        }
    
        public void setVendedor(vendedor vendedor) {
            this.vendedor = vendedor;
        }
    
        public cajero getCajero() {
            return cajero;
        }
    
        public void setCajero(cajero cajero) {
            this.cajero = cajero;
        }
    
        public BigDecimal getTotal() {
            return total;
        }
    
        public void setTotal(BigDecimal total) {
            this.total = total;
        }
    
        public BigDecimal getImpuestos() {
            return impuestos;
        }
    
        public void setImpuestos(BigDecimal impuestos) {
            this.impuestos = impuestos;
        }
    
        public LocalDateTime getFecha() {
            return fecha;
        }
    
        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }
    
        public String getObservaciones() {
            return observaciones;
        }
    
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
    }
