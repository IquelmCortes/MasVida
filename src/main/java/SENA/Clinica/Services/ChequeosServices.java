package SENA.Clinica.Services;

import SENA.Clinica.Entidades.Chequeos;
import SENA.Clinica.Entidades.Medico;
import SENA.Clinica.Entidades.Paciente;
import SENA.Clinica.Interfaces.ChequeosI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Bean de servicio
public class ChequeosServices { //Clase principal
    
    @Autowired //Bean
    private ChequeosI crud; //Llamado de la interface que contiene el crud
    
    public Chequeos saveCh(Chequeos ch){ //método de guardado
        return crud.save(ch);
    }
    
    public List<Chequeos>getCh(){ //método de llamado de objetos en lista
        List<Chequeos> chequ = crud.findAll();
        List<Chequeos> chequeN = new ArrayList<>();
        chequ.forEach(ch ->{
            Chequeos chequeo = new Chequeos();
            chequeo.setId(ch.getId());
            chequeo.setArea(ch.getArea());
            chequeo.setMedicalDate(ch.getMedicalDate());
            Medico med = ch.getMedico();
            Medico medN = new Medico();
            medN.setId(med.getId());
            medN.setName(med.getName());
            medN.setLastName(med.getLastName());
            medN.setPhone(med.getPhone());
            medN.setSpecialty(med.getSpecialty());
            chequeo.setMedico(medN);
            Paciente pac = ch.getPaciente();
            Paciente pacN = new Paciente();
            pacN.setId(pac.getId());
            pacN.setName(pac.getName());
            pacN.setLastName(pac.getLastName());
            pacN.setAddress(pac.getAddress());
            pacN.setPhone(pac.getPhone());
            pacN.setBirthDay(pac.getBirthDay());
            chequeo.setPaciente(pacN);
            chequeN.add(chequeo);
        });
        return chequeN;
    }
    
    public Optional<Chequeos> getChById(Integer id){ //método de obtención de objeto por id
        return crud.findById(id);
    }
    
    public void deleteCh(Integer id){ //método de eliminación
        crud.deleteById(id);
    }
}
