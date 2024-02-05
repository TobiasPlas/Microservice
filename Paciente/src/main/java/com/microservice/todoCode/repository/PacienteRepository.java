package com.microservice.todoCode.repository;

import com.microservice.todoCode.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
    @Query("SELECT p FROM Paciente p WHERE p.dni=:dni")
    Paciente findByDni(String dni);
    
}
