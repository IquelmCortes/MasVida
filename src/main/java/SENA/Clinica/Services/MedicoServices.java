package SENA.Clinica.Services;

import SENA.Clinica.Entidades.Chequeos;
import SENA.Clinica.Interfaces.MedicoI;
import SENA.Clinica.Entidades.Medico;
import SENA.Clinica.Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Bean de servicio
public class MedicoServices { //clase principal
    
    @Autowired //Bean para llamado de interface 
    private MedicoI crud; //Llamado de intarface de crud
    
    public Medico saveMed(Medico med){ //método de guardado
        return crud.save(med);
    }
    
    public List<Medico>getMed(){ //método para obtención de lista de objetos
        List<Medico> medicos = crud.findAll();
        List<Medico> med = new ArrayList<>();
        medicos.forEach(medico1 -> {
            Medico medi = new Medico();
            medi.setId(medico1.getId());
            medi.setName(medico1.getName());
            medi.setLastName(medico1.getLastName());
            medi.setPhone(medico1.getPhone());
            medi.setSpecialty(medico1.getSpecialty());
            List<Chequeos> cheq = medico1.getCh();
            List<Chequeos> cheqN = new ArrayList<>();
            cheq.forEach(ch ->{
                Chequeos chequeos = new Chequeos();
                chequeos.setId(ch.getId());
                chequeos.setMedicalDate(ch.getMedicalDate());
                chequeos.setArea(ch.getArea());
                cheqN.add(chequeos);
            });
            medi.setCh(cheqN);
            List<Paciente> pac = medico1.getPaciente();
            List<Paciente> pacN = new ArrayList<>();
            pac.forEach(paci ->{
                Paciente paciente = new Paciente();
                paciente.setId(paci.getId());
                paciente.setName(paci.getName());
                paciente.setLastName(paci.getLastName());
                paciente.setPhone(paci.getPhone());
                paciente.setBirthDay(paci.getBirthDay());
                paciente.setPopulation(paci.getPopulation());
                paciente.setStateC(paci.getStateC());
                paciente.setAddress(paci.getAddress());
                pacN.add(paciente);
            });
            medi.setPaciente(pacN);
            med.add(medi);
        });
        return med;
    }
    
    public Optional<Medico> getMedById(Integer id){ //método de obtención de objeto por id
        return crud.findById(id);
    }
    
    public void deleteMed(Integer id){ //método de elimiación
        crud.deleteById(id);
    }
}
