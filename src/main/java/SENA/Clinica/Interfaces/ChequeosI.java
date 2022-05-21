package SENA.Clinica.Interfaces;

import SENA.Clinica.Entidades.Chequeos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChequeosI extends JpaRepository<Chequeos, Integer>{ //Creación del crud
    
}
