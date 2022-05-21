package SENA.Clinica.Controller;

import SENA.Clinica.Entidades.Medicamentos;
import SENA.Clinica.Services.MedicamentosServices;
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

@RestController //Bean para el controlador
@CrossOrigin //Bean para abrir permisos de consumo de api
@RequestMapping("/api/Medicamentos") //Ruta del controlador
public class MedicamentosController { //Clase principal
    
    @Autowired //Bean para llamado del servicio
    private MedicamentosServices service; //Llamado del servicio que contiene los métodos
    
    @GetMapping(path = "/all") //Ruta para traer lista de objetos
    public List<Medicamentos> getAllMd(){ //método que consume el servicio con la ruta
        return service.getMd();
    }
    
    @GetMapping(path = "/{id}") //Ruta para traer objeto por id
    public Optional<Medicamentos> getMdById(@PathVariable Integer id) { //método que consume el servicio con la ruta
        return service.getMdById(id);
    }
    
    @PostMapping(path="/save") //Ruta para guardar objeto
    public ResponseEntity<Medicamentos> saveMd(@RequestBody Medicamentos md){ //método que consume el servicio con la ruta
        Medicamentos mdSaved = service.saveMd(md);
        if(mdSaved.getName() == null || mdSaved.getDosis()== null || mdSaved.getPaciente()== null){
            return new ResponseEntity<>(mdSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(mdSaved, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}") //Ruta para eliminar objeto
    public ResponseEntity<Medicamentos> deleteMd(@PathVariable Integer id) { //método que consume el servicio con la ruta
        service.deleteMd(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
