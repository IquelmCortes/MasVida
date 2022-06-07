package SENA.Clinica.Controller;

import SENA.Clinica.Entidades.Paciente;
import SENA.Clinica.Services.PacienteServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Bean para el controlador
@CrossOrigin //Bean para abrir permisos de consumo de api
@RequestMapping("/api/Paciente") //Ruta del controlador
public class PacienteController { //Clase principal
    
    @Autowired //Bean para llamado del servicio
    private PacienteServices service; //Llamado del servicio
    
    @GetMapping(path = "/all") //Ruta para traer lista de objetos
    public List<Paciente> getAllPac(){ //método que consume el servicio con la ruta
        return service.getPac();
    }
    
    @GetMapping(path = "Code/{id}") //Ruta para traer objeto por id
    public Paciente getPacById(@PathVariable("id") Integer id) {
        return service.getPacById(id);
    }
    
    @GetMapping(path = "/{lastName}") //Ruta para traer lista de objetos por apellído
    public List<Paciente> getPacBylastName(@PathVariable("lastName") String lastName) { //método que consume el servicio con la ruta
        return service.getPacByLastName(lastName);
    }
    
    @GetMapping(path = "/{name}/{lastName}") //Ruta para traer lista de objetos por apellído
    public Paciente getPacByNameAndLastName(@PathVariable("name") String name, @PathVariable("lastName") String lastName) { //método que consume el servicio con la ruta
        return service.getPacByNameAndLastname(name, lastName);
    }
    
    @PostMapping(path="/save") //Ruta para guardar objeto
    public ResponseEntity<Paciente> savePac(@RequestBody Paciente pac){
        Paciente pacSaved = service.savePac(pac);
        if(pacSaved.getName() == null || pacSaved.getPhone() == null){
            return new ResponseEntity<>(pacSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pacSaved, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}") //Ruta para eliminación de objeto
    public ResponseEntity<Paciente> deletePac(@PathVariable Integer id) {
        service.deletePac(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
