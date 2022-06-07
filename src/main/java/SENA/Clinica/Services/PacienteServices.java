package SENA.Clinica.Services;

import SENA.Clinica.Entidades.Chequeos;
import SENA.Clinica.Entidades.Medicamentos;
import SENA.Clinica.Entidades.Medico;
import SENA.Clinica.Interfaces.PacienteI;
import SENA.Clinica.Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//Bean de servicio
public class PacienteServices { //Clase principal

    @Autowired //Bean para llamado de la interface
    private PacienteI crud; //Llamado de la interface del crud

    public Paciente savePac(Paciente pac) { //método de guardado
        return crud.save(pac);
    }

    public List<Paciente> getPac() { //método para traer lista de objetos
        List<Paciente> pacientes = crud.findAll();
        List<Paciente> pacN = new ArrayList<>();
        pacientes.forEach(pacien -> {
            Paciente paci = new Paciente();
            paci.setId(pacien.getId());
            paci.setName(pacien.getName());
            paci.setLastName(pacien.getLastName());
            paci.setAddress(pacien.getAddress());
            paci.setBirthDay(pacien.getBirthDay());
            paci.setPhone(pacien.getPhone());
            paci.setPopulation(pacien.getPopulation());
            paci.setStateC(pacien.getStateC());
            List<Chequeos> cheque = pacien.getCh();
            List<Chequeos> chN = new ArrayList<>();
            cheque.forEach(ch -> {
                Chequeos chequeo = new Chequeos();
                chequeo.setId(ch.getId());
                chequeo.setArea(ch.getArea());
                chequeo.setMedicalDate(ch.getMedicalDate());
                Medico medico = ch.getMedico();
                Medico medicoN = new Medico();
                medicoN.setName(medico.getName());
                medicoN.setLastName(medico.getLastName());
                chequeo.setMedico(medicoN);
                chN.add(chequeo);
            });
            paci.setCh(chN);
            List<Medicamentos> medicamentos = pacien.getMed();
            List<Medicamentos> medicamentosN = new ArrayList<>();
            medicamentos.forEach(medica -> {
                Medicamentos medic = new Medicamentos();
                medic.setId(medica.getId());
                medic.setName(medica.getName());
                medic.setDosis(medica.getDosis());
                medic.setQuantity(medica.getQuantity());
                medicamentosN.add(medic);
            });
            paci.setMed(medicamentosN);
            Medico med = pacien.getMedico();
            Medico medN = new Medico();
            medN.setId(med.getId());
            medN.setName(med.getName());
            medN.setLastName(med.getLastName());
            medN.setPhone(med.getPhone());
            medN.setSpecialty(med.getSpecialty());
            paci.setMedico(medN);
            pacN.add(paci);
        });
        return pacN;
    }

    public List<Paciente> getPacByLastName(String lastName) { //método de llamado de lista de objetos por apellido
        List<Paciente> pacLast = crud.findAll();
        List<Paciente> pacLastN = new ArrayList<>();
        pacLast.forEach(paci -> {
            Paciente pac = new Paciente();
            if (paci.getLastName().equals(lastName)) {
                pac.setId(paci.getId());
                pac.setName(paci.getName());
                pac.setLastName(paci.getLastName());
                pac.setAddress(paci.getAddress());
                pac.setBirthDay(paci.getBirthDay());
                pac.setPhone(paci.getPhone());
                pac.setPopulation(paci.getPopulation());
                pac.setStateC(paci.getStateC());
                List<Chequeos> chequeos = paci.getCh();
                List<Chequeos> chequeosN = new ArrayList<>();
                chequeos.forEach(cheq -> {
                    Chequeos chequeo1 = new Chequeos();
                    chequeo1.setId(cheq.getId());
                    chequeo1.setArea(cheq.getArea());
                    chequeo1.setMedicalDate(cheq.getMedicalDate());
                    chequeosN.add(chequeo1);
                });
                pac.setCh(chequeosN);
                List<Medicamentos> medica = paci.getMed();
                List<Medicamentos> medicaN = new ArrayList<>();
                medica.forEach(medi -> {
                    Medicamentos me = new Medicamentos();
                    me.setId(medi.getId());
                    me.setName(medi.getName());
                    me.setDosis(medi.getDosis());
                    me.setQuantity(medi.getQuantity());
                    medicaN.add(me);
                });
                pac.setMed(medicaN);
                Medico medico = paci.getMedico();
                Medico medicoN = new Medico();
                medicoN.setId(medico.getId());
                medicoN.setName(medico.getName());
                medicoN.setLastName(medico.getLastName());
                medicoN.setPhone(medico.getPhone());
                medicoN.setSpecialty(medico.getSpecialty());
                pac.setMedico(medicoN);
                pacLastN.add(pac);
            }
        });
        return pacLastN;
    }

    public Paciente getPacByNameAndLastname(String name, String lastName) {
        List<Paciente> pacEs = crud.findAll();
        Paciente pac = new Paciente();
        pacEs.forEach(paci -> {
            if (paci.getName().equals(name) && paci.getLastName().equals(lastName)) {
                pac.setId(paci.getId());
                pac.setName(paci.getName());
                pac.setLastName(paci.getLastName());
                pac.setAddress(paci.getAddress());
                pac.setBirthDay(paci.getBirthDay());
                pac.setPhone(paci.getPhone());
                pac.setPopulation(paci.getPopulation());
                pac.setStateC(paci.getStateC());
                List<Chequeos> chequeos = paci.getCh();
                List<Chequeos> chequeosN = new ArrayList<>();
                chequeos.forEach(cheq -> {
                    Chequeos chequeo1 = new Chequeos();
                    chequeo1.setId(cheq.getId());
                    chequeo1.setArea(cheq.getArea());
                    chequeo1.setMedicalDate(cheq.getMedicalDate());
                    chequeosN.add(chequeo1);
                });
                pac.setCh(chequeosN);
                List<Medicamentos> medica = paci.getMed();
                List<Medicamentos> medicaN = new ArrayList<>();
                medica.forEach(medi -> {
                    Medicamentos me = new Medicamentos();
                    me.setId(medi.getId());
                    me.setName(medi.getName());
                    me.setDosis(medi.getDosis());
                    me.setQuantity(medi.getQuantity());
                    medicaN.add(me);
                });
                pac.setMed(medicaN);
                Medico medico = paci.getMedico();
                Medico medicoN = new Medico();
                medicoN.setId(medico.getId());
                medicoN.setName(medico.getName());
                medicoN.setLastName(medico.getLastName());
                medicoN.setPhone(medico.getPhone());
                medicoN.setSpecialty(medico.getSpecialty());
                pac.setMedico(medicoN);
            }
        });
        return pac;
    }

    public Paciente getPacById(Integer id) { //método de llamado de objeto por id
        Optional<Paciente> pacien = crud.findById(id);
        Paciente paci = new Paciente();
        paci.setId(pacien.get().getId());
        paci.setName(pacien.get().getName());
        paci.setLastName(pacien.get().getLastName());
        paci.setAddress(pacien.get().getAddress());
        paci.setBirthDay(pacien.get().getBirthDay());
        paci.setPhone(pacien.get().getPhone());
        paci.setPopulation(pacien.get().getPopulation());
        paci.setStateC(pacien.get().getStateC());
        List<Chequeos> chequeos = pacien.get().getCh();
        List<Chequeos> chequeosN = new ArrayList<>();
        chequeos.forEach(cheq -> {
            Chequeos chequeo1 = new Chequeos();
            chequeo1.setId(cheq.getId());
            chequeo1.setArea(cheq.getArea());
            chequeo1.setMedicalDate(cheq.getMedicalDate());
            Medico medico = cheq.getMedico();
            Medico nmedico = new Medico();
            nmedico.setName(medico.getName());
            nmedico.setLastName(medico.getLastName());
            chequeo1.setMedico(nmedico);
            chequeosN.add(chequeo1);
        });
        paci.setCh(chequeosN);
        List<Medicamentos> medica = pacien.get().getMed();
        List<Medicamentos> medicaN = new ArrayList<>();
        medica.forEach(medi -> {
            Medicamentos me = new Medicamentos();
            me.setId(medi.getId());
            me.setName(medi.getName());
            me.setDosis(medi.getDosis());
            me.setQuantity(medi.getQuantity());
            medicaN.add(me);
        });
        paci.setMed(medicaN);
        Medico medico = pacien.get().getMedico();
        Medico medicoN = new Medico();
        medicoN.setId(medico.getId());
        medicoN.setName(medico.getName());
        medicoN.setLastName(medico.getLastName());
        medicoN.setPhone(medico.getPhone());
        medicoN.setSpecialty(medico.getSpecialty());
        paci.setMedico(medicoN);
    return paci;
}

public void deletePac(Integer id) { //método de eliminación
        crud.deleteById(id);
    }
}
