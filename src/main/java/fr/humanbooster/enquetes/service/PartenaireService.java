package fr.humanbooster.enquetes.service;

import fr.humanbooster.enquetes.business.Partenaire;

import java.util.List;

/**
 * Created by Nea on 05/11/2016.
 */
public interface PartenaireService {
    public void genererListePartenaires();

    public List<Partenaire> recupererPartenaires();
}