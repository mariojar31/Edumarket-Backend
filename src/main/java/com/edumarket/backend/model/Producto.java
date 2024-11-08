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
    private String descripcion;
    private double precio;
    private String img;
    private CategoriaProducto categoria;
    private int stock;
    private Boolean top;
    @OneToMany(mappedBy = "producto")
    private List<OrdenProducto> detallesOrdenes;


    public  Producto(){

    }

    public Producto(Long id_producto, String nombreProducto, String descripcion, double precio, String img, CategoriaProducto categoria, int stock, Boolean top) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.img = img;
        this.categoria = categoria;
        this.stock = stock;
        this.top = top;
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
