package com.example.trabajo_integrador.controller.dto;

import com.example.trabajo_integrador.entity.Odontologo;
import com.example.trabajo_integrador.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoCreateDto implements Serializable {

    private Long Id;
    private LocalDate fecha;
     private LocalTime hora;
    private Paciente paciente;
    private Odontologo odontologo;
}
