package com.edumarket.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrdenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id_ordenProducto;
    int  cantidad;
    Long ordenId;
    Long  productoId;
    double subtotal;

    public  OrdenProducto(){

    }

    public OrdenProducto(Long id_ordenProducto, int cantidad, Long ordenId, Long productoId, double subtotal) {
        this.id_ordenProducto = id_ordenProducto;
        this.cantidad = cantidad;
        this.ordenId = ordenId;
        this.productoId = productoId;
        this.subtotal = subtotal;
    }

    public Long getId_ordenProducto() {
        return id_ordenProducto;
    }

    public void setId_ordenProducto(Long id_ordenProducto) {
        this.id_ordenProducto = id_ordenProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
