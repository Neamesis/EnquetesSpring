package fr.humanbooster.enquetes.dao.impl;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.dao.EnqueteDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

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
    public void creerEnquete(Enquete enqueteTelephone) {
        sf.getCurrentSession().save(enqueteTelephone);
    }
}
