package com.edumarket.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    Long id_orden;
    int cantidad;
    Long usuarioId;
    Date fecha;
    double  valorTotal;
    Long estadoId;

    public Orden(){

    }
    public Orden(Long id_orden, int cantidad, Long usuarioId, Date fecha, double valorTotal, Long estadoId) {
        this.id_orden = id_orden;
        this.cantidad = cantidad;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.estadoId = estadoId;
    }

    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
