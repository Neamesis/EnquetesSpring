package fr.humanbooster.enquetes.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class Question implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestion;

    private String libelle;

    @ManyToOne
    @JoinColumn(name = "idEnquete")
    private Enquete enquete;

    @OneToMany (mappedBy = "question")
    private List<ChoixPossible> choixPossibles;


    public Question() {
    }

    public Question(String libelle) {
        this.libelle = libelle;
    }

    public Question(int idQuestion, String libelle) {
        this.idQuestion = idQuestion;
        this.libelle = libelle;
    }

    public Question(String libelle, Enquete enquete) {
        this.libelle = libelle;
        this.enquete = enquete;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

}
