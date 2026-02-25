package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;



@Entity
@Data
public class AvisoMeteorologico {
    //Para que jpa sepa cual es la clave primaria y se genere automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String nivel;
    private String zona;
    private String mensaje;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public AvisoMeteorologico() {
    }

// No hacen falta constructor con parámetros y getters/setters porque Lombok lo hace

}
