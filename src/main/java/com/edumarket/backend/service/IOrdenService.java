package com.edumarket.backend.service;

import com.edumarket.backend.model.Orden;

import java.util.Date;
import java.util.List;

public interface IOrdenService {
    public List<Orden> getOrdens();

    public void saveOrden(Orden Orden);

    public void deleteOrden(Long id);

    public Orden findOrden(Long id);

    public void editOrden(Long idOriginal, int nuevoCantidad, Long nuevoUsuarioID,Date nuevaFecha, Long nuevoEstado, double nuevoTotal);
}
