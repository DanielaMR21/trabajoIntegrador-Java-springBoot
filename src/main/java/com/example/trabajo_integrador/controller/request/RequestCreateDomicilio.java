package com.example.trabajo_integrador.controller.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestCreateDomicilio implements Serializable {

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
