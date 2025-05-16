package com.example.API_REST.controller;

import com.example.API_REST.model.Matricula;
import com.example.API_REST.repository.MatriculaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@Tag(name = "Matriculas", description = "Operaciones relacionadas con las matrículas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    @Operation(summary = "Listar todas las matrículas")
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva matrícula")
    public Matricula create(@RequestBody Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una matrícula por ID")
    public Matricula getById(@PathVariable Integer id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una matrícula existente")
    public Matricula update(@PathVariable Integer id, @RequestBody Matricula matricula) {
        matricula.setId_matricula(id);
        return matriculaRepository.save(matricula);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una matrícula por ID")
    public void delete(@PathVariable Integer id) {
        matriculaRepository.deleteById(id);
    }
}

