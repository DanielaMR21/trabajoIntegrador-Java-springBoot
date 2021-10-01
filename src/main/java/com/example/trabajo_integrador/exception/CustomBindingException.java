package com.example.trabajo_integrador.exception;

import lombok.Data;

import java.util.List;

@Data
public class CustomBindingException extends CustomBaseException{

    private List<String> listaErrores;

    public CustomBindingException(String message, int codigoError, List<String> listaErrores) {
        super(message, codigoError);
        this.listaErrores = listaErrores;
    }
}
