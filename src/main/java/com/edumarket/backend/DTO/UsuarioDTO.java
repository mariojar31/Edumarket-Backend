package com.edumarket.backend.DTO;

public class UsuarioDTO {
    private Long id_usuario;
    private String nombreUsuario;
    private String email;
    private boolean is_admin;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id_usuario, String nombreUsuario, String email, boolean is_admin, Long estudianteId) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.is_admin = is_admin;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id){
        this.id_usuario = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean getIs_admin(){
        return is_admin;
    }


    

}