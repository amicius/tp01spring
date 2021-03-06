package fr.dta.modele;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private long       identifiant;
    private String     prenom, nom, secu;
    private BigDecimal salaire;
    private LocalDate       embauche;

    public Employee() {
        super();
    }

    public Employee( long identifiant, String prenom, String nom, String secu, BigDecimal salaire, LocalDate localDate ) {
        super();
        this.identifiant = identifiant;
        this.prenom = prenom;
        this.nom = nom;
        this.secu = secu;
        this.salaire = salaire;
        this.embauche = localDate;
    }

    public Employee( String prenom, String nom, String secu, BigDecimal salaire, LocalDate localDate ) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.secu = secu;
        this.salaire = salaire;
        this.embauche = localDate;    }

    public long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant( long identifiant ) {
        this.identifiant = identifiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getSecu() {
        return secu;
    }

    public void setSecu( String secu ) {
        this.secu = secu;
    }

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire( BigDecimal salaire ) {
        this.salaire = salaire;
    }

    public LocalDate getEmbauche() {
        return embauche;
    }

    public void setEmbauche( LocalDate embauche ) {
        this.embauche = embauche;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( identifiant ^ ( identifiant >>> 32 ) );
        return result;
    }

    

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Employee other = (Employee) obj;
        if ( identifiant != other.identifiant )
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [identifiant=" + identifiant + ", prenom=" + prenom + ", nom=" + nom + ", secu=" + secu
                + ", salaire=" + salaire + ", embauche=" + embauche + "]";
    }
    
   


}
