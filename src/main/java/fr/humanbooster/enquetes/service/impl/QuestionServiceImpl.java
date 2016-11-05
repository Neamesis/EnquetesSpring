package fr.humanbooster.enquetes.service.impl;

import fr.humanbooster.enquetes.dao.QuestionDao;
import fr.humanbooster.enquetes.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nea on 04/11/2016.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDao qd;

    public QuestionServiceImpl() {
    }
}
