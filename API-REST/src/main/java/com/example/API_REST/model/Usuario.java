package com.example.API_REST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        admin, soporte
    }
}

