package com.example.trabajo_integrador.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioCreateDto implements Serializable {
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
