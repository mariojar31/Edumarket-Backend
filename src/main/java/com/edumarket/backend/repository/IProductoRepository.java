package com.edumarket.backend.repository;

import com.edumarket.backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository  extends JpaRepository<Producto, Long> {// clase que voy a mapear i ID llave primary


}