package com.edumarket.backend.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.repository.IEstudianteRepository;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> getEstudiantes() {
        List<Estudiante> listaPersonas = estudianteRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void saveEstudiante(Estudiante estudiante) {
        if (estudiante.getId_estudiante() == null) {
            throw new IllegalArgumentException("El ID del estudiante no puede ser null");
        }
        estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Estudiante findEstudiante(Long id) {
        Estudiante estudiante= estudianteRepository.findById(id).orElse(null);
        return estudiante;
    }

    @Override
    public void editEstudiante(Long id, String nuevoNombr, String nuevoGrado) {

        Estudiante estudiante=this.findEstudiante(id);
        estudiante.setNombreEstudiante(nuevoNombr);
        estudiante.setGrado(nuevoGrado);

        this.saveEstudiante(estudiante);

    }

    @Override
    public void updateStudentsList(List<Estudiante> nuevosEstudiantes){
        List<Estudiante> estudiantesActuales = estudianteRepository.findAll();

        // Crear un conjunto de IDs de los estudiantes actuales para facilitar la búsqueda
        Set<Long> idsActuales = estudiantesActuales.stream()
                .map(Estudiante::getId_estudiante)
                .collect(Collectors.toSet());

        // Eliminar estudiantes que no están en la nueva lista
        for (Estudiante estudiante : estudiantesActuales) {
            if (!nuevosEstudiantes.stream().anyMatch(nuevo -> nuevo.getId_estudiante().equals(estudiante.getId_estudiante()))) {
                estudianteRepository.delete(estudiante);
            }
        }

        // Agregar nuevos estudiantes
        for (Estudiante nuevoEstudiante : nuevosEstudiantes) {
            if (!idsActuales.contains(nuevoEstudiante.getId_estudiante())) {
                estudianteRepository.save(nuevoEstudiante);
            }
        }
    }
}
