package com.edumarket.backend.service;

import com.edumarket.backend.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> getUsuarios();

    public void saveUsuario(Usuario Usuario);

    public void deleteUsuario(Long id);

    public Usuario findUsuario(Long id);

    public void editUsuario(Long idOriginal, String nuevoUsuario, String nuevoEmail, String nuevoContrasena, boolean nuevoIsAdmin, Long nuevoEstudianteid);
}
