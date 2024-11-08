package com.edumarket.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edumarket.backend.DTO.EmailRequestDTO;
import com.edumarket.backend.DTO.UsuarioDTO;
import com.edumarket.backend.config.JwtUtil;
import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.service.IEstudianteService;
import com.edumarket.backend.service.JwtUserDetails;
import com.edumarket.backend.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private JwtUserDetails userDetailsService;

    @Autowired
    private IEstudianteService studentService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/{id_estudiante}")
    public ResponseEntity<String> register(@PathVariable Long id_estudiante, @RequestBody Usuario usuario) {
        Estudiante student = studentService.findEstudiante(id_estudiante);
        if(student != null){
            usuario.setEstudiante(student);
            userService.saveUsuario(usuario);
            return ResponseEntity.ok("Usuario registrado con éxito");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Estudiante no encontrado");
        }
        
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getEmail());
        if (userDetails != null && passwordEncoder.matches(usuario.getContrasena(), userDetails.getPassword())) {
            // Generar el token JWT
            String token = jwtUtil.generateToken(userDetails.getUsername());
            System.out.println(token);

            // Establecer el contexto de seguridad
            UsernamePasswordAuthenticationToken authentication = 
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UsuarioDTO userInfo = userService.findUserByEmail(usuario.getEmail());
            Map<String, Object> response = new HashMap<>();
            response.put("token","Bearer "+token);
            response.put("user",userInfo);

            // Devolver el token como respuesta
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    
    @PostMapping("/info")
    public UsuarioDTO getUserInfo(@RequestBody EmailRequestDTO emailReq){
        String email = emailReq.getEmail();
        UsuarioDTO userInfo = userService.findUserByEmail(email);
        return userInfo;
    }


    @GetMapping("/resource")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
    }