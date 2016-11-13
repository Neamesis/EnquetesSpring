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

import java.util.ArrayList;
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
    public int creerEnqueteTel(String name, String texteAccroche, Date dateUtil) {
        System.out.println("<<<<< creer enquete tel serviceImpl : " + name);
        Enquete enqueteTelephone = new EnqueteTelephone(texteAccroche);
        enqueteTelephone.setName(name);
        enqueteTelephone.setDateEnquete(dateUtil);
        return ed.creerEnquete(enqueteTelephone);
    }

    @Override
    public int creerEnqueteInt(String name, Date dateUtil) {
        Enquete enqueteInternet = new EnqueteInternet();
        enqueteInternet.setName(name);
        enqueteInternet.setDateEnquete(dateUtil);
        return ed.creerEnquete(enqueteInternet);
    }

    @Override
    public EnqueteInternet recupererEnqueteIntParId(int idEnquete) {
        if (idEnquete == 0) {
            return null;
        } else {
            EnqueteInternet enqueteInternet = ed.recupererEnqueteParId(idEnquete);
            return enqueteInternet;
        }
    }

    @Override
    public List<Enquete> recupererEnquetesTriees(int orderBy) {
        List<Enquete> enquetes = new ArrayList<>();
        switch (orderBy) {
            case 0:
                return enquetes = ed.recupererEnquetes();
            case 1:
                return enquetes = ed.trierEnquetesParNom();
            case 2:
                return enquetes = ed.trierEnquetesParDate();
            default:
                return enquetes;
        }
    }



}
