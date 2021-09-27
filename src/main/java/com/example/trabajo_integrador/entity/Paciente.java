package com.example.trabajo_integrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "pacientes")
public class Paciente{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Domicilio domicilio;
    private LocalDate fechaDeAlta;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Turno> turnos;


}
