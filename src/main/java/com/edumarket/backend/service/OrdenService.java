package com.edumarket.backend.service;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.model.Orden;
import com.edumarket.backend.repository.IEstudianteRepository;
import com.edumarket.backend.repository.IOrdenRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdenService implements IOrdenService {

    private IOrdenRepository ordenrepository;

    @Override
    public List<Orden> getOrdens() {
        List<Orden> listaOrden = ordenrepository.findAll();
        return listaOrden;
    }

    @Override
    public void saveOrden(Orden Orden) {
        ordenrepository.save(Orden);

    }

    @Override
    public void deleteOrden(Long id) {
        ordenrepository.deleteById(id);

    }

    @Override
    public Orden findOrden(Long id) {
        Orden orden= ordenrepository.findById(id).orElse(null);
        return orden;
    }

    @Override
    public void editOrden(Long idOriginal, int nuevoCantidad, Long nuevoUsuarioID, Date nuevaFecha, Long nuevoEstado, double nuevoTotal) {

        Orden orden=this.findOrden(idOriginal);

        orden.setCantidad(nuevoCantidad);
        orden.setUsuarioId(nuevoUsuarioID);
        orden.setFecha(nuevaFecha);
        orden.setEstadoId(nuevoEstado);
        orden.setValorTotal(nuevoTotal);


        this.saveOrden(orden);
    }
}
