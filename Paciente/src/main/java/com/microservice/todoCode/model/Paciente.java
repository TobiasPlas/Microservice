package com.microservice.todoCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    @Temporal(TemporalType.DATE)
    private LocalDate fechNac;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String dni, String nombre, String apellido, String telefono, LocalDate fechNac) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechNac = fechNac;
    }
    
}
