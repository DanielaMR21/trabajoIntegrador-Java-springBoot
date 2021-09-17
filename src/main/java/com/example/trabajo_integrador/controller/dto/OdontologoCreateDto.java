package com.example.trabajo_integrador.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoCreateDto implements Serializable {

    private String apellido;
    private String nombre;
    private String matricula;
}
