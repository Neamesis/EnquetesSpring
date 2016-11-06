package fr.humanbooster.enquetes.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class EnqueteTelephone extends Enquete {

    private static final long serialVersionUID = 1L;

    private String texteAccroche;

    public EnqueteTelephone() {
        super();
    }

    public EnqueteTelephone(String texteAccroche) {
        super();
        this.texteAccroche = texteAccroche;
    }

    public String getTexteAccroche() {
        return texteAccroche;
    }

    public void setTexteAccroche(String texteAccroche) {
        this.texteAccroche = texteAccroche;
    }

    @Override
    public String toString() {
        return "EnqueteTelephone : " +
                "Nom  : " + super.getName() + " " +
                "Date : " + super.getDateEnquete() + " " +
                "Texte d'accroche= : ' " + texteAccroche + " '" +
                '.';
    }
}
