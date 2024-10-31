package com.edumarket.backend.service;

import com.edumarket.backend.model.OrdenProducto;

import java.util.List;

public interface IOrdenProductoService {
    public List<OrdenProducto> getOrdenProductos();

    public void saveOrdenProducto(OrdenProducto OrdenProducto);

    public void deleteOrdenProducto(Long id);

    public OrdenProducto findOrdenProducto(Long id);

    public void editOrdenProducto(Long idOriginal, int nuevoCantidad,Long nuevoProductoID, double subtotal);
}
