package fr.humanbooster.enquetes.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "enqueteType")
public  abstract class Enquete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idEnquete;

    protected String name;

    protected Date dateEnquete;

    @OneToMany(mappedBy = "enquete")
    protected List<Question> questions;

    @OneToMany(mappedBy = "enquete")
    protected List<Critere> criteres;

    public Enquete() {
    }

    public Enquete(String name, Date dateEnquete) {
        this.name = name;
        this.dateEnquete = new Date();
    }

    public int getIdEnquete() {
        return idEnquete;
    }

    public void setIdEnquete(int idEnquete) {
        this.idEnquete = idEnquete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateEnquete() {
        return dateEnquete;
    }

    public void setDateEnquete(Date dateEnquete) {
        this.dateEnquete = dateEnquete;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Critere> getCriteres() {
        return criteres;
    }

    public void setCriteres(List<Critere> criteres) {
        this.criteres = criteres;
    }

    @Override
    public String toString() {
        return "Enquete{" +
                "idEnquete=" + idEnquete +
                ", name='" + name + '\'' +
                ", dateEnquete=" + dateEnquete +
                '}';
    }
}
