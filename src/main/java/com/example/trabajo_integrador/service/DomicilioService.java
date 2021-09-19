package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.DomicilioCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateDomicilio;

import java.util.List;

public interface DomicilioService {

    DomicilioCreateDto registrar(RequestCreateDomicilio request);
    DomicilioCreateDto modificar(Long id, RequestCreateDomicilio request);
    List<DomicilioCreateDto> listar();
    DomicilioCreateDto buscarPorId(Long id);
    void eliminar(Long id);

}
