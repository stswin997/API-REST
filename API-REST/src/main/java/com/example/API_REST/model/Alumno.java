package com.example.API_REST.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno;

    private Integer dni;
    private String nombre;
    private String apellido;
    private Integer telefono;

    @Column(name = "correo_electronico")
    private String correoElectronico;
}
