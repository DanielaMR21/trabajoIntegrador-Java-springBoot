package com.example.trabajo_integrador.service;

import com.example.trabajo_integrador.controller.dto.OdontologoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateOdontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceImplTest {

    @Autowired
    OdontologoService odontologoService;
    RequestCreateOdontologo odontologo = new RequestCreateOdontologo();

    @Test
    void registrar() {

        odontologo.setNombre("Ruby");
        odontologo.setApellido("Morales");
        odontologo.setMatricula("132");
        odontologoService.registrar(odontologo);

        assertNotNull(odontologo);
    }

    @Test
    void buscarPorId() {
        odontologo.setNombre("Ruby");
        odontologo.setApellido("Morales");
        odontologo.setMatricula("132");
        odontologoService.registrar(odontologo);

       OdontologoCreateDto odontologoDB = odontologoService.buscarPorId(1l);
       assertNotNull(odontologoDB);

    }
}