package fr.dta.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "Entreprise" )
@SequenceGenerator( name = "entr_seq" )
public class Entreprise {
    
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "entr_seq" )
    private long           id;
    @Column
    private String         nom;
    @OneToMany
    private List<Employee> list;

    public Entreprise() {
        super();
    }

    public Entreprise( long id, String nom, List<Employee> list ) {
        super();
        this.id = id;
        this.nom = nom;
        this.list = list;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList( List<Employee> list ) {
        this.list = list;
    }

}
