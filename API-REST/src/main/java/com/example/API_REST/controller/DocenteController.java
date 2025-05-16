package com.example.API_REST.controller;

import com.example.API_REST.model.Docente;
import com.example.API_REST.repository.DocenteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@Tag(name = "Docentes", description = "Operaciones relacionadas con los docentes")
public class DocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping
    @Operation(summary = "Listar todos los docentes")
    public List<Docente> getAll() {
        return docenteRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo docente")
    public Docente create(@RequestBody Docente docente) {
        return docenteRepository.save(docente);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un docente por ID")
    public Docente getById(@PathVariable Integer id) {
        return docenteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un docente existente")
    public Docente update(@PathVariable Integer id, @RequestBody Docente docente) {
        docente.setId_docente(id);
        return docenteRepository.save(docente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un docente por ID")
    public void delete(@PathVariable Integer id) {
        docenteRepository.deleteById(id);
    }
}

