package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.OdontologoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateOdontologo;
import com.example.trabajo_integrador.entity.Odontologo;
import com.example.trabajo_integrador.repository.OdontologoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServiceImpl implements OdontologoService{

    private final OdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public OdontologoCreateDto registrar(RequestCreateOdontologo requestOdontologo) {
        Odontologo guardarOdontologo = odontologoRepository.save(Odontologo.builder().nombre(requestOdontologo.getNombre())
                .apellido(requestOdontologo.getApellido())
                .matricula(requestOdontologo.getMatricula()).build());
        return new OdontologoCreateDto(guardarOdontologo.getNombre(),guardarOdontologo.getApellido(),guardarOdontologo.getMatricula());
    }

    @Override
    public OdontologoCreateDto actualizar(Long id, RequestCreateOdontologo requestOdontologo) {
        return null;
    }

    @Override
    public OdontologoCreateDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<OdontologoCreateDto> listar() {
        return null;
    }
}
