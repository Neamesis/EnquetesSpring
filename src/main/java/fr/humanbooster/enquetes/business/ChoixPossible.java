package fr.humanbooster.enquetes.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
public class ChoixPossible implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChoixPossible;

    private String libelle;

    @OneToMany(mappedBy = "choixPossible")
    private List<Reponse> reponses;

    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question question;

    public ChoixPossible() {
    }

    public ChoixPossible(int id,String libelle, List<Reponse> reponses, Question question) {
        this.idChoixPossible = id;
        this.libelle = libelle;
        this.reponses = reponses;
        this.question = question;
    }

    public int getIdChoixPossible() {
        return idChoixPossible;
    }

    public void setIdChoixPossible(int idChoixPossible) {
        this.idChoixPossible = idChoixPossible;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
