package fr.humanbooster.enquetes.dao;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.EnqueteInternet;

import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
public interface EnqueteDao {

    public int creerEnquete(Enquete enqueteTelephone);

    public List<Enquete> recupererEnquetes();

    public EnqueteInternet recupererEnqueteParId(int idEnquete);

    public List<Enquete> trierEnquetesParNom();

    public List<Enquete> trierEnquetesParDate();
}
