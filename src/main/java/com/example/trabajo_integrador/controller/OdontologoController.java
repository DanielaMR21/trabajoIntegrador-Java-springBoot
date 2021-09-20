package com.example.trabajo_integrador.controller;

import com.example.trabajo_integrador.controller.dto.OdontologoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateOdontologo;
import com.example.trabajo_integrador.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

   private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OdontologoCreateDto guardarOdontologo(@RequestBody RequestCreateOdontologo request){
        return odontologoService.registrar(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OdontologoCreateDto modificarOdontologo(@PathVariable Long id, @RequestBody RequestCreateOdontologo request){
        return odontologoService.actualizar(id,request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OdontologoCreateDto> listarOdontologos(){
      return odontologoService.listar();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OdontologoCreateDto buscarPorId(@PathVariable Long id){
        return odontologoService.buscarPorId(id);
    }
}
