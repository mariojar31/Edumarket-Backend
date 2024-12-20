package com.edumarket.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumarket.backend.DTO.ProductoDTO;
import com.edumarket.backend.model.CategoriaProducto;
import com.edumarket.backend.model.Producto;
import com.edumarket.backend.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    private ProductoDTO convertToDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId_producto(producto.getId_producto());
        dto.setCategoria(producto.getCategoria());
        dto.setDescripcion(producto.getDescripcion());
        dto.setNombreProducto(producto.getNombreProducto());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setImg(producto.getImg());
        dto.setTop(producto.getTop());

        return dto;
    }

    @Override
    public List<ProductoDTO> getProductos() {
        List<Producto> listaProducto = productoRepository.findAll();
        return listaProducto.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void saveProducto(Producto Producto) {
        productoRepository.save(Producto);

    }

    @Override
    public void saveProductList(List<Producto> productsList){
        for(Producto product:productsList){
            productoRepository.save(product);
        }
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
    public ProductoDTO getProductoById(Long id){
        Producto producto = this.findProducto(id);
        return convertToDTO(producto);
    }

    @Override
    public void editProducto(Long id, String nuevoNombre, double nuevoPrecio, CategoriaProducto nuevaCategoria, int nuevoStock) {

        Producto producto=this.findProducto(id);
        producto.setNombreProducto(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setCategoria(nuevaCategoria);
        producto.setStock(nuevoStock);
        this.saveProducto(producto);
    }

    @Override
    public void deleteAll(){
        productoRepository.deleteAll();
    }
}
