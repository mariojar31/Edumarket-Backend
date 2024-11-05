package com.edumarket.backend.service;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import com.edumarket.backend.DTO.DetalleOrdenDTO;
import com.edumarket.backend.DTO.OrdenDTO;
import com.edumarket.backend.model.EstadoOrden;
import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.Usuario;

public interface IOrdenService {
    public List<OrdenDTO> getOrdenes();
=======
import com.edumarket.backend.model.Orden;

import java.util.Date;
import java.util.List;

public interface IOrdenService {
    public List<Orden> getOrdens();
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0

    public void saveOrden(Orden Orden);

    public void deleteOrden(Long id);

    public Orden findOrden(Long id);

<<<<<<< HEAD
    public OrdenDTO getOrdenById(Long id);

    public void editOrden(Long id, Usuario nuevoUsuario,Date nuevaFecha, EstadoOrden nuevoEstado);

    public List<DetalleOrdenDTO> getDetallesOrden(Long id);

    public List<DetalleOrdenDTO> getAllDetallesOrden();

    public Orden registrarOrden(Orden nuevaOrden, Usuario usuario);

=======
    public void editOrden(Long idOriginal, int nuevoCantidad, Long nuevoUsuarioID,Date nuevaFecha, boolean nuevoEstado, double nuevoTotal);
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0
}
