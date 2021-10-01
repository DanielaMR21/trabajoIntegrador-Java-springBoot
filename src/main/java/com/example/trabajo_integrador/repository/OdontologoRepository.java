package com.example.trabajo_integrador.repository;

import com.example.trabajo_integrador.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {

    Optional<Odontologo> findByNombre(String nombre);
}
