package com.example.trabajo_integrador.repository;

import com.example.trabajo_integrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
