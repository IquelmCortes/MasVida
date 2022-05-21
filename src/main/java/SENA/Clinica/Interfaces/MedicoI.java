package SENA.Clinica.Interfaces;

import SENA.Clinica.Entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoI extends JpaRepository<Medico, Integer>{ //Creación del crud
    
}
