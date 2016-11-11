package fr.humanbooster.enquetes.dao.impl;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.EnqueteInternet;
import fr.humanbooster.enquetes.dao.EnqueteDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nea on 04/11/2016.
 */
@Repository
@Primary
public class EnqueteDaoImpl implements EnqueteDao{

    @Autowired
    private SessionFactory sf;

    public EnqueteDaoImpl() {
    }

    public EnqueteDaoImpl(SessionFactory sessionFactory) {
    }


    @Override
    public int creerEnquete(Enquete enquete) {
        sf.getCurrentSession().save(enquete);
        return enquete.getIdEnquete();
    }

    @Override
    public List<Enquete> recupererEnquetes() {
        List<Enquete> enquetes = sf.getCurrentSession().createQuery("FROM Enquete").getResultList();
        return enquetes;
    }

    @Override
    public EnqueteInternet recupererEnqueteParId(int idEnquete) {
        return sf.getCurrentSession().byId(EnqueteInternet.class).load(idEnquete);
    }

    @Override
    public List<Enquete> trierEnquetesParNom() {
        List<Enquete> enquetes = sf.getCurrentSession().createQuery("FROM Enquete ORDER BY name").getResultList();
        return enquetes;
    }

    @Override
    public List<Enquete> trierEnquetesParDate() {
        List<Enquete> enquetes = sf.getCurrentSession().createQuery("FROM Enquete ORDER BY dateEnquete").getResultList();
        return enquetes;
    }


}
