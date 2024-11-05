package com.edumarket.backend.service;

import java.util.List;

import com.edumarket.backend.model.Estudiante;

public interface IEstudianteService {
    public List<Estudiante> getEstudiantes();

    public void saveEstudiante(Estudiante estudiante);

    public void deleteEstudiante(Long id);

    public Estudiante findEstudiante(Long id);

    public void editEstudiante(Long id, String nuevoNombr, String nuevoGrado);

    public void updateStudentsList(List<Estudiante> estudiantes);
}
