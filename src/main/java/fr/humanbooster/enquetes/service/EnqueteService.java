package fr.humanbooster.enquetes.service;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.Partenaire;

import java.util.Date;
import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
public interface EnqueteService {
    public int creerEnqueteTel(String name, String texteAccroche, Date dateUtil);

    public int creerEnqueteInt(String name, Date dateUtil);

    public List<Enquete> recupererEnquetes();
}
