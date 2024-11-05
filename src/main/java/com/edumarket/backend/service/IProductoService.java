package com.edumarket.backend.service;

import java.util.List;

import com.edumarket.backend.DTO.ProductoDTO;
import com.edumarket.backend.model.CategoriaProducto;
import com.edumarket.backend.model.Producto;

public interface IProductoService {
    public List<ProductoDTO> getProductos();

    public void saveProducto(Producto Producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);

    public ProductoDTO getProductoById(Long id);

    public void editProducto(Long id, String nuevoNombre, double nuevoPrecio, CategoriaProducto nuevaCategoria, int nuevoStock);
}
