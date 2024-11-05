package com.edumarket.backend.service;

<<<<<<< HEAD
import java.util.List;

import com.edumarket.backend.DTO.ProductoDTO;
import com.edumarket.backend.model.CategoriaProducto;
import com.edumarket.backend.model.Producto;

public interface IProductoService {
    public List<ProductoDTO> getProductos();
=======
import com.edumarket.backend.model.Producto;

import java.util.Date;
import java.util.List;

public interface IProductoService {
    public List<Producto> getProductos();
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0

    public void saveProducto(Producto Producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);

<<<<<<< HEAD
    public ProductoDTO getProductoById(Long id);

    public void editProducto(Long id, String nuevoNombre, double nuevoPrecio, CategoriaProducto nuevaCategoria, int nuevoStock);
=======
    public void editProducto(Long idOriginal, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevoStock);
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0
}
