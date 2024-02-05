package com.microservice.todoCode.controller;

import com.microservice.todoCode.model.Paciente;
import com.microservice.todoCode.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private IPacienteService pacser;
    
    @GetMapping("/traer")
    public List<Paciente> getPacientes(){
      List<Paciente> list= pacser.getPaciente();
      return list;
    }
    
    @GetMapping("/traer/{id}")
    public Paciente findPaciente(@PathVariable Long id){
        Paciente pac = pacser.findPaciente(id);
        return pac;
    }
    
    @PostMapping("/crear")
    public void savePaciente(@RequestBody Paciente pac){
        pacser.savePaciente(pac);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void deletePaciente(@PathVariable Long id){
        pacser.deletePaciente(id);
    }
    
    @PutMapping("/edit")
    public void editPaciente(@RequestBody Paciente pas){
        pacser.editPaciente(pas);
    }
    
    
      @GetMapping("/traerdni/{dni}")
    public Paciente findPacienteByDni(@PathVariable String dni){
        Paciente pac = pacser.findPacienteByDni(dni);
        return pac;
    }
}
