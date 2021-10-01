package com.example.trabajo_integrador.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RequestCreateDomicilio implements Serializable {

    @NotBlank
    private String calle;
    @NotBlank
    private String numero;
    @NotBlank
    private String localidad;
    @NotBlank
    private String provincia;
}
