package SENA.Clinica.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.*;
import lombok.Data;

@Data //Bean para getter and setter y constructores
@Entity //Bean para crear la entidad
@Table(name="chequeos") //Creación del nombre de la tabla
public class Chequeos { //clase principal
    
    @Id 
    @SequenceGenerator(name="seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Id autogenerado
    @Column
    private LocalDate medicalDate; //Fecha de chequeo
    @Column
    private String area; //área encargada
    
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id")
    @JsonIgnoreProperties("medico")
    private Medico medico; //Adición de objeto médico como parte del objeto Chequeo
    
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id")
    @JsonIgnoreProperties("paciente")
    private Paciente paciente; //Adición de objeto paciente como parte del objeto Chequeo
}
