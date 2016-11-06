package fr.humanbooster.enquetes.controller;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.EnqueteInternet;
import fr.humanbooster.enquetes.business.EnqueteTelephone;
import fr.humanbooster.enquetes.business.Partenaire;
import fr.humanbooster.enquetes.service.EnqueteService;
import fr.humanbooster.enquetes.service.PartenaireService;
import fr.humanbooster.enquetes.service.QuestionService;
import fr.humanbooster.enquetes.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nea on 04/11/2016.
 */
@Controller
public class EnquetesControleur {

    @Autowired
    private EnqueteService enqueteService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PartenaireService partenaireService;

    @Autowired
    private HttpSession hSession;

    private DateUtils dateUtils = new DateUtils();

    /**
     * Mapping de plusieurs root sur index
     * @param map
     * @return
     */
    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
    public ModelAndView pageAccueil(Map<String, Object> map) {
        List<Enquete> enquetes = enqueteService.recupererEnquetes();
        map.put("enquetes", enqueteService.recupererEnquetes());
        return new ModelAndView("index", map);
    }

    @RequestMapping(value = "/creerEnqueteTel", method = RequestMethod.GET)
    public ModelAndView creerEnqueteTelGet(@RequestParam Map<String, Object> map,
                                           @ModelAttribute("enqueteTelephone") EnqueteTelephone enqueteTelephone) {
        map.put("enqueteTelephone", new EnqueteTelephone());
        return new ModelAndView("proposer_enquete_tel", map);
    }

    @RequestMapping(value = "/creerEnqueteTel", method = RequestMethod.POST)
    public ModelAndView creerEnqueteTelPost(@ModelAttribute("enqueteTelephone") EnqueteTelephone enqueteTelephone,
                                      @RequestParam Map<String, Object> map) {

        String name = enqueteTelephone.getName();
        String texteAccroche = enqueteTelephone.getTexteAccroche();
        String dateString =  map.get("DATE").toString();

        enqueteService.creerEnqueteTel(name, texteAccroche, dateUtils.getDateFromString(dateString));

        return pageAccueil(map);
    }



    @RequestMapping(value = "/creerEnqueteInt", method = RequestMethod.GET)
    public ModelAndView creerEnqueteIntGet() {
        ModelAndView mav = new ModelAndView("proposer_enquete_int");
        List<Partenaire> partenaires = partenaireService.recupererPartenaires();
        mav.addObject("partenaires", partenaires);
        mav.addObject("enqueteInternet", new EnqueteInternet());
        return mav;
    }

    @RequestMapping(value = "/creerEnqueteInt", method = RequestMethod.POST)
    public ModelAndView creerEnquetIntPost(@RequestParam Map<String, Object> map,
                                     @ModelAttribute("enqueteInternet") EnqueteInternet enqueteInternet,
                                     BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(">>>> Echec");
            return pageAccueil(map);
        } else {
            String name = enqueteInternet.getName();
            String dateString = map.get("DATE").toString();
            String id = map.get("ID_PARTENAIRE").toString();

            Partenaire partenaire = partenaireService.recupererPartenaireParId(id);

            System.out.println("id de l'enquete : " + enqueteInternet.getIdEnquete());

            List<Partenaire> partenaireList = new ArrayList<>();
            partenaireList.add(partenaire);

            int idEnquete = enqueteService.creerEnqueteInt(name, dateUtils.getDateFromString(dateString));


            System.out.println("id de l'enquete : " + idEnquete);

            return pageAccueil(map);
        }
    }





    }
