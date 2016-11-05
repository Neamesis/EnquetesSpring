package fr.humanbooster.enquetes.business;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class Reponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReponse;

    private String adresseIp;

    private Date dateReponse;

    @ManyToOne
    @JoinColumn(name = "idChoixPossible")
    private ChoixPossible choixPossible;

    public Reponse() {
    }

    public Reponse(int idReponse, String adresseIp, Date dateReponse, ChoixPossible choixPossible) {
        this.idReponse = idReponse;
        this.adresseIp = adresseIp;
        this.dateReponse = dateReponse;
        this.choixPossible = choixPossible;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    public ChoixPossible getChoixPossible() {
        return choixPossible;
    }

    public void setChoixPossible(ChoixPossible choixPossible) {
        this.choixPossible = choixPossible;
    }
}
