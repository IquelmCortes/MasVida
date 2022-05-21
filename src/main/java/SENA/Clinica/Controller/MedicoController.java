package SENA.Clinica.Controller;

import SENA.Clinica.Entidades.Medico;
import SENA.Clinica.Services.MedicoServices;
import java.util.List;
import java.util.Optional;
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

@RestController //Bean del controlador
@CrossOrigin //Bean para abrir permisos de consumo de api
@RequestMapping("/api/Medico") //Ruta del controlador
public class MedicoController { //Clase principal
    
    @Autowired //Bean para llamado del servicio
    private MedicoServices service; //Llamado del servicio
    
    @GetMapping(path = "/all") //Ruta para traer lista de objetos 
    public List<Medico> getAllMed(){ //método que consume el servicio con la ruta
        return service.getMed();
    }
    
    @GetMapping(path = "/{id}") //Ruta para traer objeto por id
    public Optional<Medico> getMedById(@PathVariable Integer id) { //método que consume el servicio con la ruta
        return service.getMedById(id);
    }
    
    @PostMapping(path="/save") //Ruta ´para guardar objeto
    public ResponseEntity<Medico> saveMed(@RequestBody Medico med){ //método que consume el servicio con la ruta
        Medico medSaved = service.saveMed(med);
        if(medSaved.getName() == null || medSaved.getSpecialty() == null){
            return new ResponseEntity<>(medSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(medSaved, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}") //Ruta para eliminación de objeto
    public ResponseEntity<Medico> deleteMed(@PathVariable Integer id) { //método que consume el servicio con la ruta
        service.deleteMed(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
