package com.example.trabajo_integrador.controller.request;

import com.example.trabajo_integrador.entity.Domicilio;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RequestCreatePaciente implements Serializable {
    private String nombre;
    private String apellido;
    private String dni;
    private Domicilio domicilio;
    private LocalDate fechaDeAlta;
}
