package com.microservice.todoCode.service;

import com.microservice.todoCode.model.Paciente;
import java.util.List;

public interface IPacienteService {
     
    public List<Paciente> getPaciente();
    
    public Paciente findPaciente(Long id);
    
    public void savePaciente(Paciente pac);
    
    public void editPaciente(Paciente pac);
    
    public void deletePaciente(Long id);

    public Paciente findPacienteByDni(String dni);
}
