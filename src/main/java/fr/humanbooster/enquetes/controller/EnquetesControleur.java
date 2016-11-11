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
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nea on 04/11/2016.
 */
@Controller
public class EnquetesControleur {

    public static final int TRI_PAR_DEFAUT = 0;
    public static final int TRI_PAR_NOM = 1;
    public static final int TRI_PAR_DATE = 2;

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
        map.put("enquetes", enqueteService.recupererEnquetesTriees(TRI_PAR_DEFAUT));
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
            String idPartenaire = map.get("ID_PARTENAIRE").toString();

            int idEnquete = enqueteService.creerEnqueteInt(name, dateUtils.getDateFromString(dateString));
            EnqueteInternet enqueteAjoutee = enqueteService.recupererEnqueteIntParId(idEnquete);

            Partenaire partenaire = partenaireService.recupererPartenaireParId(idPartenaire);
            partenaireService.attribuerEnqueteAuPartenaire(partenaire, enqueteAjoutee);
            return pageAccueil(map);
        }
    }

    @RequestMapping(value = "/ajoutPartEnquInt", method = RequestMethod.GET)
    public ModelAndView ajoutPartenaireEnqueteIntGet(@RequestParam(name = "id") String idEnquete,
                                                     Map<String, Object> map) {
        ModelAndView mav = new ModelAndView("ajout_partenaire_enquete_int");
        EnqueteInternet enqueteInternet = enqueteService.recupererEnqueteIntParId(Integer.parseInt(idEnquete));
        mav.addObject("enqueteInternet", enqueteInternet);
        mav.addObject("partenaires", partenaireService.recupererPartenaires());
        return mav;
    }

    @RequestMapping(value = "/ajoutPartEnquInt", method = RequestMethod.POST)
    public ModelAndView ajoutPartenaireEnqueteIntPost(@RequestParam Map<String, Object> map,
                                                      @ModelAttribute("partenaire") Partenaire partenaire,
                                                      @RequestParam(name = "ID_ENQUETE") String idEnquete) {

        EnqueteInternet enqueteInternet = enqueteService.recupererEnqueteIntParId(Integer.parseInt(idEnquete));
        String idPartenaire = map.get("ID_PARTENAIRE").toString();
        partenaire = partenaireService.recupererPartenaireParId(idPartenaire);
        partenaireService.attribuerEnqueteAuPartenaire(partenaire, enqueteInternet);
        return pageAccueil(map);
    }


    @RequestMapping(value = "/departement", method = RequestMethod.GET)
    public ModelAndView ajoutDepartement() {
        ModelAndView mav = new ModelAndView("ajouter_departement");

        Map<String, String> departements = new HashMap<>();
        for (int i = 1 ; i < 96 ; i++) {
            departements.put(String.valueOf(i), String.valueOf(i));
        }
        mav.addObject("departements", departements);
        return mav;
    }

    @RequestMapping(value = "/triEnquetesParDate", method = RequestMethod.GET)
    public ModelAndView triEnquetesParDate(Map<String, Object> map) {
        map.put("enquetes", enqueteService.recupererEnquetesTriees(TRI_PAR_DATE));
        return new ModelAndView("index", map);
    }

    @RequestMapping(value = "/triEnquetesParNom", method = RequestMethod.GET)
    public ModelAndView triEnquetesParNom(Map<String, Object> map) {
        map.put("enquetes", enqueteService.recupererEnquetesTriees(TRI_PAR_NOM));
        return new ModelAndView("index", map);
    }




}
