package com.example.repository;

import com.example.model.AvisoMeteorologico;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvisoRepository  extends JpaRepository<AvisoMeteorologico, Long> {

    //Avisos personalizados
    List<AvisoMeteorologico> findByZona(String zona);
    List<AvisoMeteorologico> findByNivel(String nivel);
    List<AvisoMeteorologico> findByTipo(String tipo);




}
