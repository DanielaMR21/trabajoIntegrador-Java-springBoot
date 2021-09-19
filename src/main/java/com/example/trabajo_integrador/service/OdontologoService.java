package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.OdontologoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateOdontologo;
import com.example.trabajo_integrador.entity.Odontologo;

import java.util.List;

public interface OdontologoService {

    OdontologoCreateDto registrar(RequestCreateOdontologo request);
    OdontologoCreateDto actualizar(Long id, RequestCreateOdontologo request);
    OdontologoCreateDto buscarPorId(Long id);
    List<OdontologoCreateDto> listar();

}
