package com.example.trabajo_integrador.controller;

import com.example.trabajo_integrador.controller.dto.TurnoCreateDto;
import com.example.trabajo_integrador.controller.request.RequestCreateTurno;
import com.example.trabajo_integrador.entity.Turno;
import com.example.trabajo_integrador.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurnoCreateDto guardarTurno(@RequestBody RequestCreateTurno request){
        return turnoService.registrar(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public TurnoCreateDto modificarTurno(@PathVariable Long id, @RequestBody RequestCreateTurno request) {
          return turnoService.actualizar(id, request);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public TurnoCreateDto buscarPorId(@PathVariable Long id){
        return turnoService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<TurnoCreateDto> listar(){
        return turnoService.listar();
    }

}
