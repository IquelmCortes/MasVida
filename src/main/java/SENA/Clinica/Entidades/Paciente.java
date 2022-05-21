package SENA.Clinica.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data //Bean para getter, setter y constructor
@Entity //Bean para creación de la entidad
@Table(name="paciente") //Nombramiento de la tabla
public class Paciente { //Clase principal
    
    @Id
    @SequenceGenerator(name="seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Id autogenerado
    @Column
    private String name; //Nombre del paciente
    @Column
    private String lastName; //Apellído del paciente
    @Column
    private String phone; //Teléfono del paciente
    @Column
    private String address; //Dirección del paciente
    @Column
    private String population; //Población del paciente
    @Column
    private String stateC; //Estado del paciente
    @Column
    private String BirthDay; //Fecha de nacimiento del paciente
    
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id")
    @JsonIgnoreProperties("medico")
    private Medico medico; //Adición de objeto médico al objeto paciente
    
    @JsonIgnoreProperties("paciente")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="paciente")
    private List<Chequeos> ch = new ArrayList<>(); //Adición de lista de chequeos a objeto paciente
    
    @JsonIgnoreProperties("paciente")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="paciente")
    private List<Medicamentos> med = new ArrayList<>(); //Adición de lista de medicamentos a objeto paciente
}
