package com.microservice.Turnos.service;

import com.microservice.Turnos.model.Paciente;
import com.microservice.Turnos.model.Turno;
import com.microservice.Turnos.repository.TurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TurnoService implements ITurnoService {

     @Autowired
     TurnoRepository turep;
    
     @Autowired
     RestTemplate apiConsumir;
    
    @Override
    public List<Turno> getTurnos() {
    List<Turno> list= turep.findAll();
    return list;
   }

    @Override
    public Turno findTurno(Long id_turno) {
        Turno tur = turep.findById(id_turno).orElse(null);
        return tur;
    }

    @Override
    public Turno editTurno(Long id_turno, Turno tur) {
        
        Turno turno = this.findTurno(id_turno);
       turno.setFecha(tur.getFecha());
       turno.setTratamiento(tur.getTratamiento());
       turno.setNombreCompletoPaciente(tur.getNombreCompletoPaciente());
       
       return turno;
    }

    @Override
    public void deleteTurno(Long id_turno) {
        turep.deleteById(id_turno);
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
    
        //buscamos la api de paciente
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/paciente/traerdni/"+dniPaciente, Paciente.class);
        String nombrePaciente = pac.getNombre()+" "+pac.getApellido();
        
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombrePaciente); 
               
        turep.save(turno);
        
    }

  
    
    
}
