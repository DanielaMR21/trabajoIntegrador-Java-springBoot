package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.TurnoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateTurno;
import com.example.trabajo_integrador.entity.Turno;
import com.example.trabajo_integrador.repository.TurnoRepository;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TurnoServiceImpl implements TurnoService{

    private final TurnoRepository turnoRepository;

    public TurnoServiceImpl(TurnoRepository turnoRepository) {

        this.turnoRepository = turnoRepository;
    }

    @Override
    @Transactional
    public TurnoCreateDto registrar(RequestCreateTurno request) {
           Turno guardarTurno = turnoRepository.save(Turno.builder().fecha(request.getFecha())
                   .hora(request.getHora())
                .paciente(request.getPaciente())
                .odontologo(request.getOdontologo()).build());
        return new TurnoCreateDto(guardarTurno.getId(),guardarTurno.getFecha(), guardarTurno.getHora(),guardarTurno.getPaciente(),guardarTurno.getOdontologo());
    }

    @Override
    @Transactional
    public TurnoCreateDto actualizar(Long id, RequestCreateTurno request) {
        Turno turnoDB = turnoRepository.findById(id).orElseThrow(()->new RuntimeException("No se pudo actualizar"));
       // turnoDB.setFecha(request.getFecha());
        turnoDB.setFecha(request.getFecha());
        turnoDB.setPaciente(request.getPaciente());
        turnoDB.setOdontologo(request.getOdontologo());
        turnoRepository.save(turnoDB);
        return new TurnoCreateDto(turnoDB.getId(), turnoDB.getFecha(), turnoDB.getHora() ,turnoDB.getPaciente(),turnoDB.getOdontologo());
    }

    @Override
    @Transactional(readOnly = true)
    public TurnoCreateDto buscarPorId(Long id) {
        Turno turnoDB = turnoRepository.findById(id).orElseThrow(()->new RuntimeException("No se pudo encontrar"));
        return new TurnoCreateDto(turnoDB.getId(), turnoDB.getFecha(),turnoDB.getHora() ,turnoDB.getPaciente(),turnoDB.getOdontologo());
    }

    @Override
    @Transactional(readOnly = true)
    public Set<TurnoCreateDto> listar() {
        return turnoRepository.findAll().stream()
                .map(turno -> new TurnoCreateDto(turno.getId(), turno.getFecha(),turno.getHora() ,turno.getPaciente(), turno.getOdontologo()))
                .collect(Collectors.toSet());
    }
}
