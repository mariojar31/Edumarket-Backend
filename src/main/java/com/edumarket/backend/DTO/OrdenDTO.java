package com.edumarket.backend.DTO;

import java.sql.Date;

import com.edumarket.backend.model.EstadoOrden;

public class OrdenDTO {
    private Long idOrden;
    private int cantidad;
    private Date fecha;
    private double valorTotal;
    private EstadoOrden estado;
    private UsuarioDTO usuario; 

    public OrdenDTO() {
    }

    public OrdenDTO(Long idOrden, int cantidad, Date fecha, double valorTotal, EstadoOrden estado, UsuarioDTO usuario) {
        this.idOrden = idOrden;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.estado = estado;
        this.usuario = usuario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }


    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public double getValorTotal() {
        return valorTotal;
    }



}