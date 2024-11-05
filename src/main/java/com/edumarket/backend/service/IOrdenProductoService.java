package com.edumarket.backend.service;

<<<<<<< HEAD
import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.OrdenProducto;
import com.edumarket.backend.model.Producto;
=======
import com.edumarket.backend.model.OrdenProducto;
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0

import java.util.List;

public interface IOrdenProductoService {
    public List<OrdenProducto> getOrdenProductos();

    public void saveOrdenProducto(OrdenProducto OrdenProducto);

    public void deleteOrdenProducto(Long id);

    public OrdenProducto findOrdenProducto(Long id);

<<<<<<< HEAD
    public void editOrdenProducto(Long id, int nuevaCantidad, Producto nuevoProducto, Orden nuevaOrden, double subtotal);
=======
    public void editOrdenProducto(Long idOriginal, int nuevoCantidad,Long nuevoProductoID, double subtotal);
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0
}
