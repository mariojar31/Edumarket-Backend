package com.edumarket.backend.repository;

import com.edumarket.backend.model.OrdenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenProductoRepository extends JpaRepository<OrdenProducto, Long> {// clase que voy a mapear i ID llave primary


}