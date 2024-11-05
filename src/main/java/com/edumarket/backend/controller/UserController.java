package com.edumarket.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edumarket.backend.DTO.UsuarioDTO;
import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.service.IUsuarioService;

@RestController
public class UserController {

    @Autowired
    private IUsuarioService userService;

    @GetMapping("/usuarios/get")
    public List<UsuarioDTO> getUsuarios(){
        return userService.getUsuarios();
    }

    @PostMapping("/usuarios/new")
    public String saveUsuario(@RequestBody Usuario usuario){
        userService.saveUsuario(usuario);
        return "El Usuario fue agregado con éxito";
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
        userService.deleteUsuario(id);
        return "Usuario borrado con éxito.";
    }

    @PutMapping("/usuarios/edit/{id}")
    public String editUsuario(@PathVariable Long id, 
        @RequestParam(required = false, name = "nombre") String nombre, 
        @RequestParam(required = false, name = "email") String email, 
        @RequestParam(required = false, name = "password") String password, 
        @RequestParam(required = false, name = "estudianteId") Long estudianteId,  // Cambia a Long
        @RequestParam(required = false, name = "admin") boolean isAdmin) {
        
        userService.editUsuario(id, nombre, email, password, estudianteId, isAdmin);
        return "Usuario modificado con éxito.";
    }

    @GetMapping("/usuarios/find/{id}")
        public Usuario findUsuario(@PathVariable Long id){
        return userService.findUsuario(id);
    }
    
}