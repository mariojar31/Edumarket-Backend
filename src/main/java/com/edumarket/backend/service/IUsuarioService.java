package com.edumarket.backend.service;

<<<<<<< HEAD
import java.util.List;

import com.edumarket.backend.DTO.UsuarioDTO;
import com.edumarket.backend.model.Usuario;


public interface IUsuarioService {
    public List<UsuarioDTO> getUsuarios();
=======
import com.edumarket.backend.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> getUsuarios();
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0

    public void saveUsuario(Usuario Usuario);

    public void deleteUsuario(Long id);

    public Usuario findUsuario(Long id);

<<<<<<< HEAD
    public void editUsuario(Long id, String nuevoUsuario, String nuevoEmail, String nuevoContrasena, Long estudianteId, boolean nuevoIsAdmin);
=======
    public void editUsuario(Long idOriginal, String nuevoUsuario, String nuevoEmail, String nuevoContrasena, boolean nuevoIsAdmin, Long nuevoEstudianteid);
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0
}
