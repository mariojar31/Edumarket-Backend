package com.edumarket.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edumarket.backend.DTO.DetalleOrdenDTO;
import com.edumarket.backend.DTO.OrdenDTO;
import com.edumarket.backend.model.EstadoOrden;
import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.OrdenProducto;
import com.edumarket.backend.model.Producto;
import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.repository.IOrdenRepository;
import com.edumarket.backend.service.IOrdenProductoService;
import com.edumarket.backend.service.IOrdenService;
import com.edumarket.backend.service.IProductoService;
import com.edumarket.backend.service.IUsuarioService;

@RestController
public class OrdenController {
    @Autowired
    private IOrdenService orderService;
    @Autowired
    private IOrdenProductoService detallesService;
    @Autowired
    private IUsuarioService userService;
    @Autowired
    private IProductoService productService;
    @Autowired IOrdenRepository orderRepo;

    @GetMapping("/orden/get")
    public List<OrdenDTO> getOrdens(){

        return orderService.getOrdenes();
    }

    @PostMapping("/orden/new")
    public String saveOrden(@RequestParam Long idUsuario){
        Usuario usuario = userService.findUsuario(idUsuario);
        Orden nuevaOrden = new Orden();
        nuevaOrden = orderService.registrarOrden(nuevaOrden, usuario);
        return "El Orden fue agregado con éxito con ID: " + nuevaOrden.getId_orden();
    }

    @DeleteMapping("/orden/delete/{id}")
    public String deleteOrden(@PathVariable Long id){
        orderService.deleteOrden(id);
        return "Orden borrado con éxito.";
    }

    @PutMapping("/orden/edit/{id}")
    public String editOrden(@PathVariable Long id,
                                @RequestParam(required=false, name="nombre") Usuario usuario,
                                @RequestParam(required=false, name="fecha") Date fecha,
                                @RequestParam(required=false, name="estado") EstadoOrden estado){
        orderService.editOrden(id,usuario,fecha,estado);
        return "Orden modificado con éxito.";
    }

    @GetMapping("/orden/detalles")
    public List<DetalleOrdenDTO> getAllDetallesOrden(){
        return orderService.getAllDetallesOrden();
    }

    @GetMapping("/orden/detalles/{id}")
    public List<DetalleOrdenDTO> detallesOrden(@PathVariable Long id){
        return orderService.getDetallesOrden(id);
    }

    @PostMapping("/orden/{id}/detalles")
    public String addDetalleOrden(@PathVariable Long id, @RequestBody Map<String, Object> rq) {
        Orden orden = orderService.findOrden(id);
        if (orden == null) {
            return "Orden no encontrada.";
        }
        Producto product = productService.findProducto(((Number) rq.get("productoId")).longValue());

        OrdenProducto detalle = new OrdenProducto();        
        // Establece la orden en el detalle
        detalle.setOrden(orden);
        detalle.setCantidad(((Number) rq.get("cantidad")).intValue());
        detalle.setProducto(product);        
        // Calcula el subtotal
        detalle.setSubtotal(detalle.getCantidad() * product.getPrecio()); 
        // Guarda el detalle de la orden
        detallesService.saveOrdenProducto(detalle);
        // Actualiza la cantidad de productos y valorTotal de la orden
        orden.setCantidad(orden.getCantidad()+detalle.getCantidad());
        orden.setValorTotal(orden.getValorTotal()+detalle.getSubtotal());

        orderRepo.save(orden);
        
        return "¡Registro agregado con éxito!";
    }


}