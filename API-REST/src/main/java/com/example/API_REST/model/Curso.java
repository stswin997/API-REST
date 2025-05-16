package com.example.API_REST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_curso;

    private String nombre_curso;
    private Double precio;
}

