package fr.humanbooster.enquetes.business;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class EnqueteInternet extends Enquete {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "enqueteInternet", fetch = FetchType.EAGER)
    private List<Partenaire> partenaires;

    public EnqueteInternet() {
        super();
    }

    public EnqueteInternet(List<Partenaire> partenaires) {
        this.partenaires = partenaires;
    }

    public List<Partenaire> getPartenaires() {
        return partenaires;
    }

    public void setPartenaires(List<Partenaire> partenaires) {
        this.partenaires = partenaires;
    }

    @Override
    public String toString() {
        return "EnqueteInternet{" +
                "partenaires=" + partenaires +
                '}';
    }
}
