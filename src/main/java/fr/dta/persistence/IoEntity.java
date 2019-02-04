package fr.dta.persistence;

import java.io.Serializable;

public interface IoEntity extends Serializable {

    Long getIdentifiant();

    void setIdentifiant( Long identifiant );

}
