package com.edumarket.backend.DTO;

import com.edumarket.backend.model.CategoriaProducto;

public class ProductoDTO {
    private Long id_producto;
    private String nombreProducto;
    private double precio;
    private CategoriaProducto categoria;
    private int stock;

    public ProductoDTO() {
    }

    public ProductoDTO(Long id_producto, String nombreProducto, double precio, CategoriaProducto categoria, int stock) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
}