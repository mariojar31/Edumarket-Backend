package com.edumarket.backend.repository;

import com.edumarket.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Long> {// clase que voy a mapear i ID llave primary


}