package SENA.Clinica.Controller;

import SENA.Clinica.Entidades.Chequeos;
import SENA.Clinica.Services.ChequeosServices;
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

@RestController//Bean de controlador
@CrossOrigin //permisos para consumir api
@RequestMapping("/api/Chequeos") //ruta del controlador
public class ChequeosController { //Clase principal
    
    @Autowired //Bean para llamar el servicio
    private ChequeosServices service; //Llamado del servicio que contiene los métodos
    
    @GetMapping(path = "/all") //Ruta del método de obtención de lista de objetos
    public List<Chequeos> getAllCh(){ //método que consume el servicio con la ruta
        return service.getCh();
    }
    
    @GetMapping(path = "/{id}") //Ruta del método de obtención de objeto por id
    public Optional<Chequeos> getChById(@PathVariable Integer id) { //método que consume el servicio con la ruta
        return service.getChById(id);
    }
    
    @PostMapping(path="/save") //Ruta para guardar objeto
    public ResponseEntity<Chequeos> saveCh(@RequestBody Chequeos ch){ //método que consume el servicio con la ruta
        Chequeos chSaved = service.saveCh(ch);
        if(chSaved.getMedico() == null || chSaved.getPaciente()== null || chSaved.getArea()== null){
            return new ResponseEntity<>(chSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(chSaved, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}") //Ruta para elimiación de objeto
    public ResponseEntity<Chequeos> deleteCh(@PathVariable Integer id) { //método que consume el servicio con la ruta
        service.deleteCh(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
