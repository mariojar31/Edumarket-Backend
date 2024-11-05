package com.edumarket.backend.controller;

import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.repository.IUsuarioRepository;
import com.edumarket.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class usuarioController {
   @Autowired
    private UsuarioService usuarioService;

   @GetMapping
    public List<Usuario> getUsuarios(){
       return usuarioService.getUsuarios();

   }
   @PostMapping
    public void crearUsuario(@RequestBody Usuario usuario){
       usuarioService.saveUsuario(usuario);
   }

   @PutMapping("/{id}")
    public void modificar(@PathVariable Long id, @RequestBody Usuario usuario){

         usuarioService.editUsuario(id,usuario.getNombreUsuario(),usuario.getEmail(),
                usuario.getContrasena(),usuario.getisIs_admin(),usuario.getestudiante());

   }

   @DeleteMapping("/{id}")
    public void deleteUusario(@PathVariable Long id, @RequestBody Usuario usuario){

       usuarioService.deleteUsuario(id);
   }

}
