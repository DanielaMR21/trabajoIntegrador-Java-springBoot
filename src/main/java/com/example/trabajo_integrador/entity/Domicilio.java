package com.example.trabajo_integrador.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "paciente_id")
//    private Paciente paciente;
}
