package com.edumarket.backend.service;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.model.Producto;
import com.edumarket.backend.repository.IEstudianteRepository;
import com.edumarket.backend.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProducto = productoRepository.findAll();
        return listaProducto;
    }

    @Override
    public void saveProducto(Producto Producto) {
        productoRepository.save(Producto);

    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);

    }

    @Override
    public Producto findProducto(Long id) {
        Producto producto= productoRepository.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void editProducto(Long idOriginal, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevoStock) {

        Producto producto=this.findProducto(idOriginal);
        producto.setNombreProducto(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setCategoria(nuevaCategoria);
        producto.setStock(nuevoStock);
        this.saveProducto(producto);
    }
}
