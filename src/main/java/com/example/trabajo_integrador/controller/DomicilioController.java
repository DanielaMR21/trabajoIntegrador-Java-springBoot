package com.example.trabajo_integrador.controller;

import com.example.trabajo_integrador.controller.dto.DomicilioCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateDomicilio;
import com.example.trabajo_integrador.entity.Domicilio;
import com.example.trabajo_integrador.service.DomicilioService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.PushBuilder;
import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private final DomicilioService domicilioService;


    public DomicilioController(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DomicilioCreateDto guardarDomicilio(@RequestBody RequestCreateDomicilio request) {
        return domicilioService.registrar(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioCreateDto modificarDomicilio(@PathVariable Long id, @RequestBody RequestCreateDomicilio request) {
        return domicilioService.modificar(id, request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DomicilioCreateDto> listar() {
        return domicilioService.listar();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioCreateDto buscarPorId(@PathVariable Long id){
        return domicilioService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminar(id);
        return "Se ha eliminado el domicilio";
    }
}
