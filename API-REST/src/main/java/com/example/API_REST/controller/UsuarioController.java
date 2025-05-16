package com.example.API_REST.controller;


import com.example.API_REST.model.Usuario;
import com.example.API_REST.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios del sistema")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @Operation(summary = "Listar todos los usuarios")
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID")
    public Usuario getById(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario existente")
    public Usuario update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId_usuario(id);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario por ID")
    public void delete(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}

