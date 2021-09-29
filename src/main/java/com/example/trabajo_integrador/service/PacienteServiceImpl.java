package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.PacienteCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreatePaciente;
import com.example.trabajo_integrador.entity.Paciente;
import com.example.trabajo_integrador.exception.CustomBaseException;
import com.example.trabajo_integrador.repository.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
       this.pacienteRepository = pacienteRepository;
    }

    @Override
    @Transactional
    public PacienteCreateDto registrar(RequestCreatePaciente request) {
        Paciente guaradarPaciente = pacienteRepository.save(Paciente.builder().nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .domicilio(request.getDomicilio())
                .fechaDeAlta(request.getFechaDeAlta())
                .build());
        return new PacienteCreateDto(guaradarPaciente.getId(), guaradarPaciente.getNombre(),guaradarPaciente.getApellido(),guaradarPaciente.getDni(),guaradarPaciente.getDomicilio(),guaradarPaciente.getFechaDeAlta());
    }

    @Override
    @Transactional
    public PacienteCreateDto actualizar(Long id, RequestCreatePaciente request) {
        Paciente pacienteDB = pacienteRepository.findById(id).orElseThrow(() ->
        {
            throw new CustomBaseException("Paciente no encontrado, por favor revise.", HttpStatus.BAD_REQUEST.value());
        });
        pacienteDB.setNombre(request.getNombre());
        pacienteDB.setApellido(request.getApellido());
        pacienteDB.setDni(request.getDni());
        pacienteDB.setDomicilio(request.getDomicilio());
        pacienteDB.setFechaDeAlta(request.getFechaDeAlta());
        pacienteRepository.save(pacienteDB);
        return new PacienteCreateDto(pacienteDB.getId(), pacienteDB.getNombre(),pacienteDB.getApellido(),pacienteDB.getDni(),pacienteDB.getDomicilio(),pacienteDB.getFechaDeAlta());
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteCreateDto buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() ->
        {
            throw new CustomBaseException("Paciente no encontrado, por favor revise.", HttpStatus.BAD_REQUEST.value());
        });
        return new PacienteCreateDto(paciente.getId(), paciente.getNombre(),paciente.getApellido(),paciente.getDni(),paciente.getDomicilio(),paciente.getFechaDeAlta());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteCreateDto> listar() {
        return pacienteRepository.findAll().stream()
                .map(paciente -> new PacienteCreateDto(paciente.getId(), paciente.getNombre(),paciente.getApellido(),paciente.getApellido(),paciente.getDomicilio(),paciente.getFechaDeAlta()))
                .collect(Collectors.toList());
    }
}
