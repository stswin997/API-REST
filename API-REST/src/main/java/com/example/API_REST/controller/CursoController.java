package com.example.API_REST.controller;

import com.example.API_REST.model.Curso;
import com.example.API_REST.repository.CursoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@Tag(name = "Cursos", description = "Operaciones relacionadas con los cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    @Operation(summary = "Listar todos los cursos")
    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo curso")
    public Curso create(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un curso por ID")
    public Curso getById(@PathVariable Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un curso existente")
    public Curso update(@PathVariable Integer id, @RequestBody Curso curso) {
        curso.setId_curso(id);
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un curso por ID")
    public void delete(@PathVariable Integer id) {
        cursoRepository.deleteById(id);
    }
}
