package com.example.trabajo_integrador.controller.dto;

import com.example.trabajo_integrador.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteCreateDto implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Domicilio domicilio;
    private LocalDate fechaDeAlta;
}
