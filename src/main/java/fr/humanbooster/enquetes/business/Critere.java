package fr.humanbooster.enquetes.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class Critere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCritere;

    private int departement;

    private String fait;

    private int quota;

    @ManyToOne
    @JoinColumn(name = "idEnquete")
    private Enquete enquete;

    public Critere() {
    }

    public Critere(int departement, int quota, String fait) {
        this.departement = departement;
        this.fait = fait;
        this.quota = quota;
    }

    public int getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(int id) {
        this.idCritere = id;
    }

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public String getFait() {
        return fait;
    }

    public void setFait(String fait) {
        this.fait = fait;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }
}
