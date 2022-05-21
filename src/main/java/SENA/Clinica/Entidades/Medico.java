package SENA.Clinica.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

@Data //Bean para getter, setter y constructor
@Entity //Bean para creación de la entidad
@Table(name="medico") //Nombramiento de la tabla
public class Medico { //Clase principal
    
    @Id
    @SequenceGenerator(name="seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Id autogenerado
    @Column
    private String name; //Nombre del médico
    @Column
    private String lastName; //Apellido del médico
    @Column
    private String phone; //Teléfono del médico
    @Column
    private String specialty; //Especialidad del médico
    
    @JsonIgnoreProperties("medico")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="medico")
    private List<Paciente> paciente = new ArrayList<>(); //Adición de lista de pacientes al objeto médico
    
    @JsonIgnoreProperties("medico")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="medico")
    private List<Chequeos> ch = new ArrayList<>(); //Adición de lista de chequeos al objeto médico
    
    @JsonIgnoreProperties("medico")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="medico")
    private List<Medicamentos> med = new ArrayList<>(); //Adición de lista de medicamentos al objeto médico
}
