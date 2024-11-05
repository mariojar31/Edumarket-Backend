package com.edumarket.backend.service;

import java.util.Date;
import java.util.List;

import com.edumarket.backend.DTO.DetalleOrdenDTO;
import com.edumarket.backend.DTO.OrdenDTO;
import com.edumarket.backend.model.EstadoOrden;
import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.Usuario;

public interface IOrdenService {
    public List<OrdenDTO> getOrdenes();

    public void saveOrden(Orden Orden);

    public void deleteOrden(Long id);

    public Orden findOrden(Long id);

    public OrdenDTO getOrdenById(Long id);

    public void editOrden(Long id, Usuario nuevoUsuario,Date nuevaFecha, EstadoOrden nuevoEstado);

    public List<DetalleOrdenDTO> getDetallesOrden(Long id);

    public List<DetalleOrdenDTO> getAllDetallesOrden();

    public Orden registrarOrden(Orden nuevaOrden, Usuario usuario);

}
