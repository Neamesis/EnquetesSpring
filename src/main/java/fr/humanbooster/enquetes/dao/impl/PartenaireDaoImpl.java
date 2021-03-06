package fr.humanbooster.enquetes.dao.impl;

import fr.humanbooster.enquetes.business.EnqueteInternet;
import fr.humanbooster.enquetes.business.Partenaire;
import fr.humanbooster.enquetes.dao.PartenaireDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nea on 05/11/2016.
 */
@Repository
@Primary
public class PartenaireDaoImpl  implements PartenaireDao{

    @Autowired
    private SessionFactory sf;

    public PartenaireDaoImpl() {
    }

    public PartenaireDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void genererListePartenaires(List<Partenaire> partenaires) {
        for(Partenaire partenaire : partenaires) {
            sf.getCurrentSession().save(partenaire);
        }
    }

    @Override
    public List<Partenaire> recupererPartenaires() {
        return sf.getCurrentSession().createQuery("FROM Partenaire").getResultList();
    }

    @Override
    public Partenaire recupererPartenaireParId(int id) {
        return sf.getCurrentSession().byId(Partenaire.class).load(id);
    }

    @Override
    public void creerPartenaire(Partenaire partenaire) {
        sf.getCurrentSession().save(partenaire);
    }

    @Override
    public void attribuerEnqueteAuPartenaire(Partenaire partenaire, EnqueteInternet enquete) {
        partenaire.setEnqueteInternet(enquete);
        sf.getCurrentSession().saveOrUpdate(partenaire);
    }
}
