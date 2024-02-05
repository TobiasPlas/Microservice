package com.microservice.Turnos.service;

import com.microservice.Turnos.model.Turno;
import java.time.LocalDate;
import java.util.List;


public interface ITurnoService {
    
    public List<Turno> getTurnos();
    
    public Turno findTurno(Long id_turno);
    
    public Turno editTurno(Long id_turno,Turno tur);
    
    public void deleteTurno(Long id_turno);
    
    public void saveTurno(LocalDate fecha ,String tratamiento , String dniPaciente);
}
