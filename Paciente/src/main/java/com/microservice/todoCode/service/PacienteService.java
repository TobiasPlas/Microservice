package com.microservice.todoCode.service;

import com.microservice.todoCode.model.Paciente;
import com.microservice.todoCode.repository.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private PacienteRepository pacrep;
    
    @Override
    public List<Paciente> getPaciente() {
       List<Paciente> lista = pacrep.findAll();
       return lista;
    }


    @Override
    public void savePaciente(Paciente pac) {
        pacrep.save(pac);
    }

    @Override
    public void editPaciente(Paciente pac) {
       this.savePaciente(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacrep.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
      Paciente pac = pacrep.findById(id).orElse(null);
      return pac;
    }

    @Override
    public Paciente findPacienteByDni(String dni) {
        return pacrep.findByDni(dni);
    }
}
