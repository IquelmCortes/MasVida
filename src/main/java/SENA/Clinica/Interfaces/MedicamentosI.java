package SENA.Clinica.Interfaces;

import SENA.Clinica.Entidades.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicamentosI extends JpaRepository<Medicamentos, Integer>{ //Creación del crud
    
}
