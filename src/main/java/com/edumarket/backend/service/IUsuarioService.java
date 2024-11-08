package com.edumarket.backend.service;

import java.util.List;

import com.edumarket.backend.DTO.UsuarioDTO;
import com.edumarket.backend.model.Usuario;


public interface IUsuarioService {
    public List<UsuarioDTO> getUsuarios();

    public void saveUsuario(Usuario Usuario);

    public void deleteUsuario(Long id);

    public Usuario findUsuario(Long id);

    public void editUsuario(Long id, String nuevoUsuario, String nuevoEmail, String nuevoContrasena, Long estudianteId, boolean nuevoIsAdmin);

    public UsuarioDTO findUserByEmail(String email);
}
