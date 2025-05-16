package com.example.API_REST.controller;

import com.example.API_REST.model.Programacion;
import com.example.API_REST.repository.ProgramacionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programaciones")
@Tag(name = "Programaciones", description = "Operaciones relacionadas con la programación de cursos")
public class ProgramacionController {

    @Autowired
    private ProgramacionRepository programacionRepository;

    @GetMapping
    @Operation(summary = "Listar todas las programaciones")
    public List<Programacion> getAll() {
        return programacionRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva programación")
    public Programacion create(@RequestBody Programacion programacion) {
        return programacionRepository.save(programacion);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una programación por ID")
    public Programacion getById(@PathVariable Integer id) {
        return programacionRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una programación existente")
    public Programacion update(@PathVariable Integer id, @RequestBody Programacion programacion) {
        programacion.setId_programacion(id);
        return programacionRepository.save(programacion);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una programación por ID")
    public void delete(@PathVariable Integer id) {
        programacionRepository.deleteById(id);
    }
}


