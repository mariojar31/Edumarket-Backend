package com.edumarket.backend.service;

import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.OrdenProducto;
import com.edumarket.backend.model.Producto;
import com.edumarket.backend.repository.IOrdenProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class OrdenProductoService implements IOrdenProductoService {

    @Autowired
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
    public void editOrdenProducto(Long id, int nuevaCantidad, Producto nuevoProducto, Orden nuevaOrden, double subtotal) {

        OrdenProducto ordenproducto=this.findOrdenProducto(id);
        ordenproducto.setCantidad(nuevaCantidad);
        ordenproducto.setProducto(nuevoProducto);
        ordenproducto.setSubtotal(subtotal);
        this.saveOrdenProducto(ordenproducto);

    }

    
}
