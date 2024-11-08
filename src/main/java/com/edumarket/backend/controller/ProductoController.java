package com.edumarket.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edumarket.backend.DTO.ProductoDTO;
import com.edumarket.backend.model.CategoriaProducto;
import com.edumarket.backend.model.Producto;
import com.edumarket.backend.service.IProductoService;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productService;

    @GetMapping("/producto/get")
    public List<ProductoDTO> getProductos(){
        return productService.getProductos();
    }

    @PostMapping("/producto/new")
    public String saveProducto(@RequestBody Producto producto){
        productService.saveProducto(producto);
        return "El Producto fue agregado con éxito";
    }

    @PostMapping("/producto/addlist")
    public String addProductsList(@RequestBody List<Producto> productos){
        productService.saveProductList(productos);
        return "Productos agregados con éxito...";
    }

    @DeleteMapping("/producto/delete/{id}")
    public String deleteProducto(@PathVariable Long id){
        productService.deleteProducto(id);
        return "Producto borrado con éxito.";
    }

    @PutMapping("/producto/edit/{id}")
    public String editProducto(@PathVariable Long id, 
        @RequestParam(required=false, name="nombre") String nombre, 
        @RequestParam(required=false, name="estado") CategoriaProducto categoria, 
        @RequestParam(required=false, name="precio") double precio,
        @RequestParam(required=false, name="stock") int stock){
        productService.editProducto(id,nombre,precio,categoria, stock);
        return "Producto modificado con éxito.";
    }

    @GetMapping("/producto/find/{id}")
    public ProductoDTO findProducto(@PathVariable Long id){
        return productService.getProductoById(id);
    }

    @GetMapping("/producto/deleteall")
    public String deleteAll(){
        productService.deleteAll();
        return "Productos eliminados con exito";
    }
    
}