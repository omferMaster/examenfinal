package com.examenFinal.webProject.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private tienda tienda;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "cajero_id")
    private cajero cajero;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
}
