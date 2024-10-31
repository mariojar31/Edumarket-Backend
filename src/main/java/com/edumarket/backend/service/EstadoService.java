package com.edumarket.backend.service;

import com.edumarket.backend.model.Estado;
import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.repository.IEstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements IEstadoService {
    private IEstadoRepository estadoRepository;

    @Override
    public List<Estado> getEstado() {
        List<Estado> listaEstado = estadoRepository.findAll();
        return listaEstado;
    }

    @Override
    public void savePersona(Estado estado) {
        estadoRepository.save(estado);
    }
}
