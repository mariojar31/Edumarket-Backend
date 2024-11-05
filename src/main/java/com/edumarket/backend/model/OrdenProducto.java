package com.edumarket.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_ordenProducto;
    private int  cantidad;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name="id_orden")
    private Orden orden;
    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;
    

    public  OrdenProducto(){

    }

    public OrdenProducto(Long id_ordenProducto, int cantidad, Long ordenId, Long productoId, double subtotal) {
        this.id_ordenProducto = id_ordenProducto;
        this.cantidad = cantidad;

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


    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
