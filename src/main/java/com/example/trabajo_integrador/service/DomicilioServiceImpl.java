package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.DomicilioCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateDomicilio;
import com.example.trabajo_integrador.entity.Domicilio;
import com.example.trabajo_integrador.entity.Odontologo;
import com.example.trabajo_integrador.repository.DomicilioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomicilioServiceImpl implements DomicilioService{

    private final DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }


    @Override
    @Transactional
    public DomicilioCreateDto registrar(RequestCreateDomicilio request) {
        Domicilio guardarDomicilio = domicilioRepository.save(Domicilio.builder().calle(request.getCalle())
                .numero(request.getNumero())
                .localidad(request.getLocalidad())
                .provincia(request.getProvincia()).build());
        return new DomicilioCreateDto(guardarDomicilio.getId(), guardarDomicilio.getCalle(),guardarDomicilio.getNumero(),guardarDomicilio.getLocalidad(),guardarDomicilio.getProvincia());
    }

    @Override
    @Transactional
    public DomicilioCreateDto modificar(Long id, RequestCreateDomicilio request) {
        Domicilio domicilioDB = domicilioRepository.findById(id).orElseThrow(()->new RuntimeException("Ocurrio un error al actualizar el domicilio"));
        domicilioDB.setCalle(request.getCalle());
        domicilioDB.setNumero(request.getNumero());
        domicilioDB.setLocalidad(request.getLocalidad());
        domicilioDB.setProvincia(request.getProvincia());
        domicilioRepository.save(domicilioDB);
        return new DomicilioCreateDto(domicilioDB.getId(), domicilioDB.getCalle(),domicilioDB.getNumero(),domicilioDB.getLocalidad(),domicilioDB.getProvincia());

    }

    @Override
    @Transactional(readOnly = true)
    public List<DomicilioCreateDto> listar() {
         return domicilioRepository.findAll().stream()
                 .map(domicilio -> new DomicilioCreateDto(domicilio.getId(), domicilio.getCalle(),domicilio.getNumero(),domicilio.getLocalidad(),domicilio.getProvincia()))
                 .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DomicilioCreateDto buscarPorId(Long id) {
        Domicilio domicilioDB = domicilioRepository.findById(id).orElseThrow(()->new RuntimeException("Error al buscar un domicilio"));
        return new DomicilioCreateDto(domicilioDB.getId(), domicilioDB.getCalle(),domicilioDB.getNumero(),domicilioDB.getLocalidad(),domicilioDB.getProvincia());

    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }
}
