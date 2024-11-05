package com.edumarket.backend.service;

import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.OrdenProducto;
import com.edumarket.backend.model.Producto;

import java.util.List;

public interface IOrdenProductoService {
    public List<OrdenProducto> getOrdenProductos();

    public void saveOrdenProducto(OrdenProducto OrdenProducto);

    public void deleteOrdenProducto(Long id);

    public OrdenProducto findOrdenProducto(Long id);

    public void editOrdenProducto(Long id, int nuevaCantidad, Producto nuevoProducto, Orden nuevaOrden, double subtotal);
}
