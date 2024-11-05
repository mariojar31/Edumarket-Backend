package com.edumarket.backend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_usuario;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    private boolean is_admin;
    @OneToOne
    @JoinColumn(name="estudianteId", referencedColumnName="id_estudiante")
    private Estudiante estudiante;
    @OneToMany(mappedBy="usuario")
    private List<Orden> ordenes;


    public Usuario(){

    }

    public Usuario(Long id_usuario, String nombreUsuario, String email, String contrasena, boolean is_admin, Estudiante estudiante) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.is_admin = is_admin;
        this.estudiante = estudiante;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }



    
}
