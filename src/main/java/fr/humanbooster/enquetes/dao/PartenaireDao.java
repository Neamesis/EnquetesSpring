package fr.humanbooster.enquetes.dao;

import fr.humanbooster.enquetes.business.Partenaire;

import java.util.List;

/**
 * Created by Nea on 05/11/2016.
 */
public interface PartenaireDao {
    public void genererListePartenaires(List<Partenaire> partenaires);

    public List<Partenaire> recupererPartenaires();
}
