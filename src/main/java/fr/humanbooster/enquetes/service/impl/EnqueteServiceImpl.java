package fr.humanbooster.enquetes.service.impl;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.EnqueteInternet;
import fr.humanbooster.enquetes.business.EnqueteTelephone;
import fr.humanbooster.enquetes.business.Partenaire;
import fr.humanbooster.enquetes.dao.EnqueteDao;
import fr.humanbooster.enquetes.service.EnqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public void creerEnqueteTel(String name, String texteAccroche, Date dateUtil) {
        Enquete enqueteTelephone = new EnqueteTelephone(texteAccroche);
        enqueteTelephone.setName(name);
        enqueteTelephone.setDateEnquete(dateUtil);
        ed.creerEnquete(enqueteTelephone);
    }

    @Override
    public void creerEnqueteInt(String name, Date dateUtil, List<Partenaire> partenaireList) {
        Enquete enqueteInternet = new EnqueteInternet(partenaireList);
        enqueteInternet.setName(name);
        enqueteInternet.setDateEnquete(dateUtil);
        ed.creerEnquete(enqueteInternet);
    }
}
