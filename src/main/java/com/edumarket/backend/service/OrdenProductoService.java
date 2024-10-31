package com.edumarket.backend.service;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.model.OrdenProducto;
import com.edumarket.backend.repository.IEstudianteRepository;
import com.edumarket.backend.repository.IOrdenProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenProductoService implements IOrdenProductoService {

    private IOrdenProductoRepository ordenProductoRepository;

    @Override
    public List<OrdenProducto> getOrdenProductos() {
        List<OrdenProducto> listaOrdenProducto = ordenProductoRepository.findAll();
        return listaOrdenProducto;
    }

    @Override
    public void saveOrdenProducto(OrdenProducto OrdenProducto) {
        ordenProductoRepository.save(OrdenProducto);

    }

    @Override
    public void deleteOrdenProducto(Long id) {
        ordenProductoRepository.deleteById(id);

    }

    @Override
    public OrdenProducto findOrdenProducto(Long id) {
        OrdenProducto ordenproducto= ordenProductoRepository.findById(id).orElse(null);
        return ordenproducto;
    }

    @Override
    public void editOrdenProducto(Long idOriginal, int nuevoCantidad, Long nuevoProductoID, double nuevoSubtotal) {

        OrdenProducto ordenproducto=this.findOrdenProducto(idOriginal);
        ordenproducto.setCantidad(nuevoCantidad);
        ordenproducto.setProductoId(nuevoProductoID);
        ordenproducto.setSubtotal(nuevoSubtotal);

        this.saveOrdenProducto(ordenproducto);

    }
}
