package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.OdontologoCreateDto;
import com.example.trabajo_integrador.controller.dto.TurnoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateOdontologo;
import com.example.trabajo_integrador.controller.request.RequestCreateTurno;

import java.util.Set;

public interface TurnoService {
    TurnoCreateDto registrar(RequestCreateTurno request);
    TurnoCreateDto actualizar(Long id, RequestCreateTurno request);
    TurnoCreateDto buscarPorId(Long id);
    Set<TurnoCreateDto> listar();
}
