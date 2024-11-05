package com.edumarket.backend.service;

<<<<<<< HEAD
import java.util.List;

import com.edumarket.backend.model.Estudiante;

=======
import com.edumarket.backend.model.Estado;
import com.edumarket.backend.model.Estudiante;

import java.util.List;

>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0
public interface IEstudianteService {
    public List<Estudiante> getEstudiantes();

    public void saveEstudiante(Estudiante estudiante);

    public void deleteEstudiante(Long id);

    public Estudiante findEstudiante(Long id);

<<<<<<< HEAD
    public void editEstudiante(Long id, String nuevoNombr, String nuevoGrado);

    public void updateStudentsList(List<Estudiante> estudiantes);
=======
    public void editEstudiante(Long idOriginal, String nuevoNombr, String nuevoGrado);
>>>>>>> ce1517c08bd0b3119004acaa08a72091def9cdc0
}
