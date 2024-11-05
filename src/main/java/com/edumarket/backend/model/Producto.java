package com.edumarket.backend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;
    private String nombreProducto;
    private double precio;
    private CategoriaProducto categoria;
    private int stock;
    @OneToMany(mappedBy = "producto")
    private List<OrdenProducto> detallesOrdenes;


    public  Producto(){

    }

    public Producto(Long id_producto, String nombreProducto, double precio, CategoriaProducto categoria, int stock) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDetallesOrdenes(List<OrdenProducto> detallesOrdenes) {
        this.detallesOrdenes = detallesOrdenes;
    }

    public List<OrdenProducto> getDetallesOrdenes() {
        return detallesOrdenes;
    }
}
