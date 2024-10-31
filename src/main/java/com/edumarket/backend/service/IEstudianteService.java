package com.edumarket.backend.service;

import com.edumarket.backend.model.Estado;
import com.edumarket.backend.model.Estudiante;

import java.util.List;

public interface IEstudianteService {
    public List<Estudiante> getEstudiantes();

    public void saveEstudiante(Estudiante estudiante);

    public void deleteEstudiante(Long id);

    public Estudiante findEstudiante(Long id);

    public void editEstudiante(Long idOriginal, String nuevoNombr, String nuevoGrado);
}
