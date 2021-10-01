package com.example.trabajo_integrador.controller;

import com.example.trabajo_integrador.controller.dto.DomicilioCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateDomicilio;
import com.example.trabajo_integrador.entity.Domicilio;
import com.example.trabajo_integrador.exception.CustomBindingException;
import com.example.trabajo_integrador.service.DomicilioService;
import com.example.trabajo_integrador.utils.Utils;
import jdk.jshell.execution.Util;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.PushBuilder;
import javax.validation.Valid;
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
    public DomicilioCreateDto guardarDomicilio(@Valid @RequestBody RequestCreateDomicilio request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
          // throw new CustomBindingException("Errores encontrados, por favor revise e intente de nuevo",Utils.listaErrores(bindingResult), HttpStatus.BAD_REQUEST.value());
        }
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
