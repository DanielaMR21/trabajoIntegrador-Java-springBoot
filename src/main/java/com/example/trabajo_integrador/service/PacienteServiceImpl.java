package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.PacienteCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreatePaciente;
import com.example.trabajo_integrador.entity.Paciente;
import com.example.trabajo_integrador.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
       this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteCreateDto registrar(RequestCreatePaciente request) {
        Paciente guaradarPaciente = pacienteRepository.save(Paciente.builder().nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .domicilio(request.getDomicilio())
                .fechaDeAlta(request.getFechaDeAlta())
                .build());
        return new PacienteCreateDto(guaradarPaciente.getNombre(),guaradarPaciente.getApellido(),guaradarPaciente.getDni(),guaradarPaciente.getDomicilio(),guaradarPaciente.getFechaDeAlta());
    }

    @Override
    public PacienteCreateDto actualizar(Long id, RequestCreatePaciente request) {
        return null;
    }

    @Override
    public PacienteCreateDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<PacienteCreateDto> listar() {
        return null;
    }
}
