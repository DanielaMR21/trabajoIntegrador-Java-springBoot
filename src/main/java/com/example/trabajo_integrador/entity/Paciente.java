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
    @SequenceGenerator(name = "pacientes_sequence", sequenceName = "pacientes_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacientes_sequence")
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
