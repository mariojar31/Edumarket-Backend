package com.edumarket.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edumarket.backend.DTO.UsuarioDTO;
import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.repository.IEstudianteRepository;
import com.edumarket.backend.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId_usuario(usuario.getId_usuario());
        dto.setEmail(usuario.getEmail());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setIs_admin(usuario.getIs_admin());       

        return dto;
    }

    @Override
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);
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
    public void editUsuario(Long id, String nuevoUsuario, String nuevoEmail, String nuevoContrasena, Long estudianteId, boolean nuevoIsAdmin) {
        Usuario usuario = this.findUsuario(id);
        
        if (nuevoUsuario != null) {
            usuario.setNombreUsuario(nuevoUsuario);
        }
        if (nuevoEmail != null) {
            usuario.setEmail(nuevoEmail);
        }
        if (nuevoContrasena != null) {
            usuario.setContrasena(nuevoContrasena);
        }
        if (estudianteId != null) {
            Estudiante estudiante = estudianteRepository.findById(estudianteId).orElse(null);
            usuario.setEstudiante(estudiante);  // Asigna el nuevo estudiante
            estudiante.setUsuario(usuario);
            estudianteRepository.save(estudiante);
        }
        usuario.setIs_admin(nuevoIsAdmin);
        this.saveUsuario(usuario);
    }

    @Override
    public UsuarioDTO findUserByEmail(String email){
        System.out.println(email);
        Usuario userFound = usuarioRepository.findByEmail(email);
        UsuarioDTO userInfo = new UsuarioDTO();
        userInfo.setNombreUsuario(userFound.getNombreUsuario());
        userInfo.setEmail(userFound.getEmail());
        userInfo.setIs_admin(userFound.getIs_admin());

        System.out.println(userInfo);

        return userInfo;
    }
}
