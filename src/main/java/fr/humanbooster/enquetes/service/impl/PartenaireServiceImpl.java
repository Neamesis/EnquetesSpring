package fr.humanbooster.enquetes.service.impl;

import fr.humanbooster.enquetes.business.Partenaire;
import fr.humanbooster.enquetes.dao.PartenaireDao;
import fr.humanbooster.enquetes.service.PartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nea on 05/11/2016.
 */
@Service
@Transactional
public class PartenaireServiceImpl implements PartenaireService {

    @Autowired
    private PartenaireDao pd;

    @Override
    public void genererListePartenaires() {
        List<Partenaire> partenaires = new ArrayList<>();
        partenaires.add(new Partenaire("Super Sponsor","supersponsor.com"));
        partenaires.add(new Partenaire("Tu vas gagner","gagner.com"));
        partenaires.add(new Partenaire("Coka coula","coula.com"));
        partenaires.add(new Partenaire("Tartiflette4ever","vivelefromage.com"));
        partenaires.add(new Partenaire("Lasagnes en folie","superpose.com"));
        partenaires.add(new Partenaire("Chat noir","blackcat.com"));
        pd.genererListePartenaires(partenaires);
    }

    @Override
    public List<Partenaire> recupererPartenaires() {
        List<Partenaire> partenaires = pd.recupererPartenaires();
        return partenaires;
    }
}
