package com.example.trabajo_integrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @SequenceGenerator(name = "turnos_sequence", sequenceName = "turnos_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnos_sequence")
    private Long Id;
    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    @JsonIgnore
    private Odontologo odontologo;


}
