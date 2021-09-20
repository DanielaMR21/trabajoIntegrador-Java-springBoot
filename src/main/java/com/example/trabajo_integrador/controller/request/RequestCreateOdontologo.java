package com.example.trabajo_integrador.controller.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestCreateOdontologo implements Serializable {
    private String nombre;
    private String apellido;
    private String matricula;
}
