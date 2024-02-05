package com.microservice.Turnos.controller;

import com.microservice.Turnos.dto.TurnoDTO;
import com.microservice.Turnos.model.Turno;
import com.microservice.Turnos.service.ITurnoService;
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
@RequestMapping("/turno")
public class TurnoController {
   
    @Autowired
    ITurnoService tuser;
    
    @GetMapping("/traer")
    public List<Turno> getTurnos(){
      return tuser.getTurnos();               
    }
    
    @GetMapping("/traer/{id_turno}")
    public Turno findTurno(@PathVariable Long id_turno){ 
        return tuser.findTurno(id_turno); 
    }


    @DeleteMapping("/borrar/{id_turno}")
    public void deleteTurno(@PathVariable Long id_turno){
        tuser.deleteTurno(id_turno);
    }
       
    @PutMapping("/editar/{id_turno}") 
    public Turno editTurno (@PathVariable Long id_original,
                            @RequestBody Turno tur){
        
       tuser.editTurno(id_original, tur);       
       Turno turnoEditado = tuser.findTurno(id_original);
       
        return turnoEditado;
    }
    
    @PostMapping("/crear")
    public String saveTurno(@RequestBody TurnoDTO turno){
       tuser.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDni());
       return "Se guardo correctamente";
    }
}
        
