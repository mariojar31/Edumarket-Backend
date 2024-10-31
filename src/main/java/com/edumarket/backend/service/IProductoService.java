package com.edumarket.backend.service;

import com.edumarket.backend.model.Producto;

import java.util.Date;
import java.util.List;

public interface IProductoService {
    public List<Producto> getProductos();

    public void saveProducto(Producto Producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);

    public void editProducto(Long idOriginal, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevoStock);
}
