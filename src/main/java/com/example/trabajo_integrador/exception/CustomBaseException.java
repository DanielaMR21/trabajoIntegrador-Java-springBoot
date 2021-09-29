package com.example.trabajo_integrador.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomBaseException extends RuntimeException{

    private int codigoError;

    public CustomBaseException(String message, int codigoError) {
        super(message,null,true,false);
        this.codigoError = codigoError;
    }
}
