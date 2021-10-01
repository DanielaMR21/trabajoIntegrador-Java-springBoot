package com.example.trabajo_integrador.utils;


import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> listaErrores(BindingResult result){
        List<String> errores = new ArrayList<>();
        result.getFieldErrors().forEach(fe ->
        {
            errores.add(fe.getDefaultMessage());
        });

        return errores;
    }
}
