package com.example.service;

import com.example.model.AvisoMeteorologico;
import com.example.repository.AvisoRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvisoService {
   private AvisoRepository repository;

    public AvisoService(AvisoRepository repository) {
        this.repository = repository;
    }


    public AvisoMeteorologico crearAlerta (AvisoMeteorologico alerta) {
        return repository.save(alerta);
    }

    public List<AvisoMeteorologico> getTodasAlertas() {
        return repository.findAll();
    }

    public List<AvisoMeteorologico> getAlertasActivas() {

        LocalDateTime actual = LocalDateTime.now();
        List<AvisoMeteorologico> avisos = repository.findAll();
        List<AvisoMeteorologico> activas = new ArrayList<>();
//Recorremos la lista y comparamos la fecha actual con la de creacion de la alerta para comparar si esta activa o no
        for (AvisoMeteorologico am : avisos) {
            if (am.getFechaInicio() == null || am.getFechaFin() == null) continue; // saltar alertas incompletas

            boolean inicioOk = actual.isEqual(am.getFechaInicio()) || actual.isAfter(am.getFechaInicio());
            boolean finOk = actual.isBefore(am.getFechaFin());

            if (inicioOk && finOk) {
                activas.add(am);
            }
        }

        return activas;
    }

    public List<AvisoMeteorologico> getPorZona(String zona){
        return repository.findByZona(zona);
    }
    public List<AvisoMeteorologico> getPorTipo(String tipo){
        return repository.findByTipo(tipo);
    }
    public List<AvisoMeteorologico> getPorNivel(String nivel){
        return repository.findByNivel(nivel);
    }


}
