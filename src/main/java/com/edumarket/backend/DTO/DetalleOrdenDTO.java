package com.edumarket.backend.DTO;

public class DetalleOrdenDTO {
    private Long id_ordenProducto;
    private ProductoDTO producto;
    private int  cantidad;
    private double subtotal;
    private OrdenDTO orden;

    public DetalleOrdenDTO() {
    }

    public DetalleOrdenDTO(Long id_ordenProducto, ProductoDTO producto, int cantidad, double subtotal, OrdenDTO orden) {
        this.id_ordenProducto = id_ordenProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.orden = orden;
    }

public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
}
public void setProducto(ProductoDTO producto) {
    this.producto = producto;
}
public void setOrden(OrdenDTO orden) {
    this.orden = orden;
}
public void setId_ordenProducto(Long id_ordenProducto) {
    this.id_ordenProducto = id_ordenProducto;
}
public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}
public double getSubtotal() {
    return subtotal;
}
public ProductoDTO getProducto() {
    return producto;
}
public OrdenDTO getOrden() {
    return orden;
}
public Long getId_ordenProducto() {
    return id_ordenProducto;
}
public int getCantidad() {
    return cantidad;
}



}