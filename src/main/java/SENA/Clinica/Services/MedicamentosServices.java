package SENA.Clinica.Services;

import SENA.Clinica.Entidades.Medicamentos;
import SENA.Clinica.Entidades.Paciente;
import SENA.Clinica.Interfaces.MedicamentosI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Bean de servicio
public class MedicamentosServices { //Clase principal
    
    @Autowired //Bean para llamado de interface
    private MedicamentosI crud; //Llamado de interface del crud
    
    public Medicamentos saveMd(Medicamentos md){ //método de guardado
        return crud.save(md);
    }
    
    public List<Medicamentos>getMd(){ //método de obtención de lista de objetos
        List<Medicamentos> medi = crud.findAll();
        List<Medicamentos> mediN = new ArrayList<>();
        medi.forEach(med ->{
            Medicamentos medicame = new Medicamentos();
            medicame.setId(med.getId());
            medicame.setDosis(med.getDosis());
            medicame.setName(med.getName());
            medicame.setQuantity(med.getQuantity());
            Paciente pac = med.getPaciente();
            Paciente pacN = new Paciente();
            pacN.setId(pac.getId());
            pacN.setName(pac.getName());
            pacN.setLastName(pac.getLastName());
            pacN.setAddress(pac.getAddress());
            pacN.setPhone(pac.getPhone());
            pacN.setBirthDay(pac.getBirthDay());
            medicame.setPaciente(pacN);
            mediN.add(medicame);
        });
        return mediN;
    }
    
    public Optional<Medicamentos> getMdById(Integer id){ //método de obtención de objeto por id
        return crud.findById(id);
    }
    
    public void deleteMd(Integer id){ //método de eliminación
        crud.deleteById(id);
    }
}
