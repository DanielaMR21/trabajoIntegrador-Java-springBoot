package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.PacienteCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreatePaciente;

import java.util.List;

public interface PacienteService {

    PacienteCreateDto registrar(RequestCreatePaciente request);
    PacienteCreateDto actualizar(Long id, RequestCreatePaciente request);
    PacienteCreateDto buscarPorId(Long id);
    List<PacienteCreateDto> listar();
}
