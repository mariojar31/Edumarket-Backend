package com.edumarket.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id_estudiante;
    String nombreEstudiante;
    String grado;
    
    @OneToOne(mappedBy = "estudiante")
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
}
