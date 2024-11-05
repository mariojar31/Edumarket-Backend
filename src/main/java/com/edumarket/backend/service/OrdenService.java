package com.edumarket.backend.service;

import java.util.Date;
import java.util.List; 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumarket.backend.DTO.DetalleOrdenDTO;
import com.edumarket.backend.DTO.OrdenDTO;
import com.edumarket.backend.DTO.ProductoDTO;
import com.edumarket.backend.DTO.UsuarioDTO;
import com.edumarket.backend.model.EstadoOrden;
import com.edumarket.backend.model.Orden;
import com.edumarket.backend.model.OrdenProducto;
import com.edumarket.backend.model.Producto;
import com.edumarket.backend.model.Usuario;
import com.edumarket.backend.repository.IOrdenProductoRepository;
import com.edumarket.backend.repository.IOrdenRepository;


@Service
public class OrdenService implements IOrdenService {

    @Autowired
    private final IOrdenRepository ordenRepository;
    @Autowired
    private IProductoService productService;
    @Autowired
    private IOrdenProductoRepository detallesRepository;

    public OrdenService(IOrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    @Override
    public List<OrdenDTO> getOrdenes() {
        List<Orden> ordenes = ordenRepository.findAll();
        return ordenes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private DetalleOrdenDTO convertToDetalleDTO(OrdenProducto detalleOrden) {
        DetalleOrdenDTO dto = new DetalleOrdenDTO();
        dto.setId_ordenProducto(detalleOrden.getId_ordenProducto());
        dto.setOrden(convertToDTO(detalleOrden.getOrden()));
        Producto product = detalleOrden.getProducto();
        ProductoDTO productDTO = productService.getProductoById(product.getId_producto());
        dto.setProducto(productDTO);
        dto.setCantidad(detalleOrden.getCantidad());
        dto.setSubtotal(detalleOrden.getSubtotal());

        return dto;
    }


    private OrdenDTO convertToDTO(Orden orden) {
        OrdenDTO dto = new OrdenDTO();
        dto.setIdOrden(orden.getId_orden());
        dto.setCantidad(orden.getCantidad());
        dto.setValorTotal(orden.getValorTotal());
        dto.setEstado(orden.getEstado());

        // Convertir Usuario a UsuarioDTO
        if (orden.getUsuario() != null) {
            Usuario usuario = orden.getUsuario();
            UsuarioDTO userDTO = new UsuarioDTO();
            userDTO.setId_usuario(usuario.getId_usuario());
            userDTO.setEmail(usuario.getEmail());
            userDTO.setNombreUsuario(usuario.getNombreUsuario());
            userDTO.setIs_admin(usuario.getIs_admin());
            dto.setUsuario(userDTO); // Asumiendo que OrdenDTO tiene un UsuarioDTO
        }

        return dto;
    }

    @Override
    public void saveOrden(Orden orden) {
        ordenRepository.save(orden);
    }

    @Override
    public void deleteOrden(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public Orden findOrden(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public void editOrden(Long id, Usuario nuevoUsuario, Date nuevaFecha, EstadoOrden nuevoEstado) {
        Orden orden = this.findOrden(id);
        
        if (orden != null) {
            orden.setFecha(nuevaFecha);
            orden.setUsuario(nuevoUsuario); // Aquí todavía usas Usuario
            orden.setEstado(nuevoEstado);
            this.saveOrden(orden);
        } else {
            throw new RuntimeException("Orden no encontrada con id: " + id);
        }
    }

    @Override
    public List<DetalleOrdenDTO> getDetallesOrden(Long id){
        Orden orden = this.findOrden(id);
        return orden.getDetallesOrden().stream().map(this::convertToDetalleDTO).collect(Collectors.toList());
    }

    @Override
    public Orden registrarOrden(Orden nuevaOrden, Usuario usuario) {
        nuevaOrden.setUsuario(usuario); // Establece el usuario en la orden
        return ordenRepository.save(nuevaOrden); // Guarda la nueva orden
    }

    @Override
    public OrdenDTO getOrdenById(Long id){
        Orden orden = this.findOrden(id);
        return convertToDTO(orden);
    }

    @Override
    public List<DetalleOrdenDTO> getAllDetallesOrden(){
        List<OrdenProducto> detalles = detallesRepository.findAll();
        return detalles.stream().map(this::convertToDetalleDTO).collect(Collectors.toList());
    }

}
