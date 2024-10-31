package com.edumarket.backend.repository;

import com.edumarket.backend.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {// clase que voy a mapear i ID llave primary


}