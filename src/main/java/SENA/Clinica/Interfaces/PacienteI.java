package SENA.Clinica.Interfaces;

import SENA.Clinica.Entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteI extends JpaRepository<Paciente, Integer> { //Creación del crud
}
