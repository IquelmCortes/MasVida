package SENA.Clinica.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data //Bean para getter, setter y constructor
@Entity //Bean para creación de la entidad
@Table(name="medicamentos") //Nombramiento de la tabla
public class Medicamentos { //Clase principal
    
    @Id
    @SequenceGenerator(name="seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Id autogenerado
    @Column
    private String name; //nombre del medicamento
    @Column
    private String quantity; //cantidad de ese medicamento
    @Column
    private String dosis; //dosis recetada para el medicamento
    
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id")
    @JsonIgnoreProperties("medico")
    private Medico medico; //Adición de objeto médico a objeto medicamentos
    
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id")
    @JsonIgnoreProperties("paciente")
    private Paciente paciente; //Adición de objeto paciente a objeto medicamentos
    
}
