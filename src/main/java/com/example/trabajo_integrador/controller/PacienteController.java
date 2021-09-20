package com.example.trabajo_integrador.controller;

import com.example.trabajo_integrador.controller.dto.PacienteCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreatePaciente;
import com.example.trabajo_integrador.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;


    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteCreateDto guardarPaciente(@RequestBody RequestCreatePaciente request){
        return pacienteService.registrar(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteCreateDto modificarPaciente(@PathVariable Long id, @RequestBody RequestCreatePaciente request){
        return pacienteService.actualizar(id, request);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteCreateDto buscarPorId(@PathVariable Long id){
        return pacienteService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PacienteCreateDto> listar(){
        return pacienteService.listar();
    }
}
