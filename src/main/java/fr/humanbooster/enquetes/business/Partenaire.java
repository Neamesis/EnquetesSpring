package fr.humanbooster.enquetes.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class Partenaire implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartenaire;

    private String namePartenaire;

    private String siteWebPartenaire;

    @ManyToOne
    @JoinColumn(name = "idEnquete")
    private EnqueteInternet enqueteInternet;

    public Partenaire() {
    }

    public Partenaire(String namePartenaire, String siteWebPartenaire) {
        this.namePartenaire = namePartenaire;
        this.siteWebPartenaire = siteWebPartenaire;
    }

    public int getIdPartenaire() {
        return idPartenaire;
    }

    public void setIdPartenaire(int idPartenaire) {
        this.idPartenaire = idPartenaire;
    }

    public String getNamePartenaire() {
        return namePartenaire;
    }

    public void setNamePartenaire(String namePartenaire) {
        this.namePartenaire = namePartenaire;
    }

    public String getSiteWebPartenaire() {
        return siteWebPartenaire;
    }

    public void setSiteWebPartenaire(String siteWebPartenaire) {
        this.siteWebPartenaire = siteWebPartenaire;
    }

    public EnqueteInternet getEnqueteInternet() {
        return enqueteInternet;
    }

    public void setEnqueteInternet(EnqueteInternet enqueteInternet) {
        this.enqueteInternet = enqueteInternet;
    }
}
