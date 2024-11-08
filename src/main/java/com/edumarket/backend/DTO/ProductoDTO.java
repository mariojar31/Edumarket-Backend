package com.edumarket.backend.DTO;

import com.edumarket.backend.model.CategoriaProducto;

public class ProductoDTO {
    private Long id_producto;
    private String nombreProducto;
    private String descripcion;
    private double precio;
    private String img;
    private CategoriaProducto categoria;
    private int stock;
    private Boolean top;
    public ProductoDTO() {
    }

    public ProductoDTO(Long id_producto, String nombreProducto, String descripcion, double precio, String img, CategoriaProducto categoria, int stock, Boolean top) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.descripcion = descripcion;
        this.img = img;
        this.top = top;
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getImg() {
        return img;
    }

    public Boolean getTop() {
        return top;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }
    
}