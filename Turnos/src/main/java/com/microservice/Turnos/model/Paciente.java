
package com.microservice.Turnos.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    
  private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fechNac;
    
}
