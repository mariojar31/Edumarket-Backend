package com.edumarket.backend.service;

import com.edumarket.backend.model.Estado;

import java.util.List;

public interface IEstadoService {

    public List<Estado> getEstado();
    public void savePersona(Estado estado);
}
