package com.edumarket.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Estudiante {
    @Id
    @Column(unique = true, nullable = false)
    private Long id_estudiante;
    private String nombreEstudiante;
    private String grado;
    @OneToOne(mappedBy="estudiante")
    @JsonIgnore
    private Usuario usuario;

    public Estudiante(){

    }
    public Estudiante(Long id_estudiante, String nombreEstudiante, String grado) {
        this.id_estudiante = id_estudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.grado = grado;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
