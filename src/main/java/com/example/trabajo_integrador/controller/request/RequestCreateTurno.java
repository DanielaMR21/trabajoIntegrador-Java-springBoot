package com.example.trabajo_integrador.controller.request;

import com.example.trabajo_integrador.entity.Odontologo;
import com.example.trabajo_integrador.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class RequestCreateTurno implements Serializable {

    private LocalDate fecha;
    @NotNull
    private LocalTime hora;
    private Paciente paciente;
    private Odontologo odontologo;
}
