package com.edumarket.backend.repository;

import com.edumarket.backend.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepository extends JpaRepository<Orden, Long> {// clase que voy a mapear i ID llave primary


}