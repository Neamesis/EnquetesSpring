package fr.humanbooster.enquetes.dao.impl;

import fr.humanbooster.enquetes.dao.QuestionDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by Nea on 04/11/2016.
 */
@Repository
@Primary
public class QuestionDaoImpl implements QuestionDao{

    @Autowired
    private SessionFactory sf;

    public QuestionDaoImpl() {
    }

    public QuestionDaoImpl(SessionFactory sf) {
        this.sf = sf;
    }

}
