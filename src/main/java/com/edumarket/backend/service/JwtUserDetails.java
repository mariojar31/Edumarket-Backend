package com.edumarket.backend.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.repository.IUsuarioRepository;

@Service
public class JwtUserDetails implements  UserDetailsService{

    private final IUsuarioRepository userRepository;

    public JwtUserDetails(IUsuarioRepository userRepository){
        this.userRepository=userRepository;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getIs_admin()) {  // Verifica si es admin
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getContrasena(), authorities);
    }
}