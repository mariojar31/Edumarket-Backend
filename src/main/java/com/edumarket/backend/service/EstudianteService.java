package com.edumarket.backend.service;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.repository.IEstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService{

private IEstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> getEstudiantes() {
        List<Estudiante> listaPersonas = estudianteRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void saveEstudiante(Estudiante estudiante) {
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
    public void editEstudiante(Long idOriginal, String nuevoNombr, String nuevoGrado) {

        Estudiante estudiante=this.findEstudiante(idOriginal);
        estudiante.setNombreEstudiante(nuevoNombr);
        estudiante.setGrado(nuevoGrado);

        this.saveEstudiante(estudiante);


    }
}
