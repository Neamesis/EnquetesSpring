package fr.humanbooster.enquetes.service.impl;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.EnqueteTelephone;
import fr.humanbooster.enquetes.dao.EnqueteDao;
import fr.humanbooster.enquetes.service.EnqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nea on 04/11/2016.
 */
@Service
@Transactional
public class EnqueteServiceImpl implements EnqueteService{

    @Autowired
    private EnqueteDao ed;

    public EnqueteServiceImpl() {
    }


    @Override
    public void creerEnquete(String name, String texteAccroche) {
        Enquete enqueteTelephone = new EnqueteTelephone(texteAccroche);
        enqueteTelephone.setName(name);
        ed.creerEnquete(enqueteTelephone);
    }
}
