package com.example.trabajo_integrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "odontologos")
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologos_sequence", sequenceName = "odontologos_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologos_sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Turno> turnos;

}
