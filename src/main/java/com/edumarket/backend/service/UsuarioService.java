package com.edumarket.backend.service;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.repository.IEstudianteRepository;
import com.edumarket.backend.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
    }

    @Override
    public void saveUsuario(Usuario Usuario) {
        usuarioRepository.save(Usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario= usuarioRepository.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public void editUsuario(Long idOriginal, String nuevoUsuario, String nuevoEmail, String nuevoContrasena, boolean nuevoIsAdmin, Long nuevoEstudianteid) {
        Usuario usuario=this.findUsuario(idOriginal);
        usuario.setNombreUsuario(nuevoUsuario);
        usuario.setEmail(nuevoEmail);
        usuario.setContrasena(nuevoContrasena);
        usuario.setIs_admin(nuevoIsAdmin);
        usuario.setEstudianteId(nuevoEstudianteid);

        this.saveUsuario(usuario);


    }
}
