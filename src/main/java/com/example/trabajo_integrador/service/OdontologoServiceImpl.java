package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.OdontologoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateOdontologo;
import com.example.trabajo_integrador.entity.Odontologo;
import com.example.trabajo_integrador.exception.CustomBaseException;
import com.example.trabajo_integrador.repository.OdontologoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OdontologoServiceImpl implements OdontologoService{

    private final OdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    @Transactional
    public OdontologoCreateDto registrar(RequestCreateOdontologo requestOdontologo) {
        Odontologo guardarOdontologo = odontologoRepository.save(Odontologo.builder().nombre(requestOdontologo.getNombre())
                .apellido(requestOdontologo.getApellido())
                .matricula(requestOdontologo.getMatricula()).build());
        return new OdontologoCreateDto(guardarOdontologo.getId(), guardarOdontologo.getNombre(),guardarOdontologo.getApellido(),guardarOdontologo.getMatricula());
    }

    @Override
    @Transactional
    public OdontologoCreateDto actualizar(Long id, RequestCreateOdontologo requestOdontologo) {
        Odontologo odontologoDB = odontologoRepository.findById(id).orElseThrow(() ->
        {
            throw new CustomBaseException("Odontologo no encontrado, por favor revise.", HttpStatus.BAD_REQUEST.value());
        });
        odontologoDB.setNombre(requestOdontologo.getNombre());
        odontologoDB.setApellido(requestOdontologo.getApellido());
        odontologoDB.setMatricula(requestOdontologo.getMatricula());
        odontologoRepository.save(odontologoDB);
        return new OdontologoCreateDto(odontologoDB.getId(), odontologoDB.getNombre(),odontologoDB.getApellido(),odontologoDB.getMatricula());
    }

    @Override
    @Transactional(readOnly = true)
    public OdontologoCreateDto buscarPorId(Long id) {
        Odontologo odontologo = odontologoRepository.findById(id).orElseThrow(()->
                {
                    throw new CustomBaseException("Odontologo no encontrado, por favor revise.", HttpStatus.BAD_REQUEST.value());
                });

        return new OdontologoCreateDto(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(),odontologo.getMatricula());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OdontologoCreateDto> listar() {
        return odontologoRepository.findAll().stream()
                .map(odontologo -> new OdontologoCreateDto(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<OdontologoCreateDto> findByNombre(String nombre) {
        return odontologoRepository.findByNombre(nombre).stream()
                .map(odontologo -> new OdontologoCreateDto(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula()))
                .collect(Collectors.toSet());
    }
}
