package com.example.API_REST.controller;

import com.example.API_REST.model.Alumno;
import com.example.API_REST.repository.AlumnoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@Tag(name = "Alumnos", description = "Operaciones relacionadas con los alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    @Operation(summary = "Listar todos los alumnos")
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo alumno")
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un alumno por ID")
    public Alumno getById(@PathVariable Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un alumno existente")
    public Alumno update(@PathVariable Integer id, @RequestBody Alumno alumno) {
        alumno.setId_alumno(id);
        return alumnoRepository.save(alumno);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un alumno por ID")
    public void delete(@PathVariable Integer id) {
        alumnoRepository.deleteById(id);
    }
}
