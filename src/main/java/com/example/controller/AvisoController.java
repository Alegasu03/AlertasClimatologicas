package com.example.controller;

import com.example.model.AvisoMeteorologico;
import com.example.service.AvisoService;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avisos")
public class AvisoController {
    private final AvisoService service;

    public AvisoController(AvisoService service) {
        this.service = service;
    }
    @GetMapping
    public List<AvisoMeteorologico> getAvisos(){
        return service.getTodasAlertas();
    }

    @GetMapping("/activas")
    public List<AvisoMeteorologico> getActivas(){
        return  service.getAlertasActivas();
    }

    @GetMapping("/zona/{zona}")
    public List<AvisoMeteorologico> getPorZona(@PathVariable String zona){
        return service.getPorZona(zona);
    }
    @PostMapping
    public AvisoMeteorologico crearAlerta(@RequestBody AvisoMeteorologico alerta){
        return service.crearAlerta(alerta);
    }

}
