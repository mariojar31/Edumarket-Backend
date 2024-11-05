package com.edumarket.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edumarket.backend.model.Estudiante;
import com.edumarket.backend.service.IEstudianteService;

@RestController
public class EstudianteController {
    @Autowired
    private IEstudianteService studentService;

    @GetMapping("/estudiantes/get")
    public List<Estudiante> getEstudiantes(){
        return studentService.getEstudiantes();
    }

    @PostMapping("/estudiantes/new")
    public String saveEstudiante(@RequestBody Estudiante estudiante){
        studentService.saveEstudiante(estudiante);
        return "El estudiante fue agregado con éxito";
    }

    @DeleteMapping("/estudiantes/delete/{id}")
    public String deleteEstudiante(@PathVariable Long id){
        studentService.deleteEstudiante(id);
        return "Estudiante borrado con éxito.";
    }

    @PutMapping("/estudiantes/edit/{id}")
    public String editEstudiante(@PathVariable Long id,
                                @RequestParam(required=false, name="nombre") String nombre,
                                @RequestParam(required=false, name="grado") String grado){
        studentService.editEstudiante(id,nombre,grado);
        return "Estudiante modificado con éxito.";
    }

    @GetMapping("/estudiantes/find/{id}")
    public Estudiante findEstudiante(@PathVariable Long id){
        return studentService.findEstudiante(id);
    }

    @PostMapping("/estudiantes/update")
    public String updateEstudiantes(@RequestBody List<Estudiante> estudiantes){
        studentService.updateStudentsList(estudiantes);
        return "Estudiantes Actualizados con éxito";
    }
}