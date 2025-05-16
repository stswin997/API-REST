package com.example.API_REST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Docente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_docente;

    private String nombre;
    private String apellido;
    private String especialidad;

    @Column(name = "correo_electronico")
    private String correoElectronico;
}

