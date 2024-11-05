package com.edumarket.backend.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_orden;
    private int cantidad;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fecha;
    double  valorTotal;
    @Enumerated(EnumType.STRING)
    private EstadoOrden estado;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy="orden")
    private List<OrdenProducto> detallesOrden;
    

    public Orden(){
        this.estado = EstadoOrden.EN_PROCESO;
        this.fecha = new Date();

    }
    public Orden(Long id_orden, int cantidad, Date fecha, double valorTotal) {
        this.id_orden = id_orden;
        this.cantidad = cantidad;
        this.fecha = new Date();
        this.valorTotal = valorTotal;
        this.estado = EstadoOrden.EN_PROCESO;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setDetallesOrden(List<OrdenProducto> detalles) {
        this.detallesOrden = detalles;
    }

    public List<OrdenProducto> getDetallesOrden() {
        return detallesOrden;
    }
}
