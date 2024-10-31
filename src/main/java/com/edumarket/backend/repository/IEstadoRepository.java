package com.edumarket.backend.repository;

import com.edumarket.backend.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoRepository extends JpaRepository<Estado, Long> {// clase que voy a mapear i ID llave primary


}