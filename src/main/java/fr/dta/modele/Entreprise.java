package fr.dta.modele;

import java.util.List;

public class Entreprise {
    private long           id;
    private String         nom;
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
