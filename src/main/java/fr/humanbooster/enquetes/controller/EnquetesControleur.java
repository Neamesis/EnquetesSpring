package fr.humanbooster.enquetes.controller;

import fr.humanbooster.enquetes.business.EnqueteInternet;
import fr.humanbooster.enquetes.business.EnqueteTelephone;
import fr.humanbooster.enquetes.business.Partenaire;
import fr.humanbooster.enquetes.service.EnqueteService;
import fr.humanbooster.enquetes.service.PartenaireService;
import fr.humanbooster.enquetes.service.QuestionService;
import fr.humanbooster.enquetes.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/creerEnqueteTel", method = RequestMethod.GET)
    public ModelAndView creerEnqueteTelGet(@RequestParam Map<String, Object> map,
                                           @ModelAttribute("enqueteTelephone") EnqueteTelephone enqueteTelephone) {
        map.put("enqueteTelephone", new EnqueteTelephone());
        return new ModelAndView("proposer_enquete_tel", map);
    }

    @RequestMapping(value = "/creerEnqueteTel", method = RequestMethod.POST)
    public String creerEnqueteTelPost(@ModelAttribute("enqueteTelephone") EnqueteTelephone enqueteTelephone,
                                      @RequestParam Map<String, Object> map) {

        String name = enqueteTelephone.getName();
        String texteAccroche = enqueteTelephone.getTexteAccroche();
        String dateString =  map.get("DATE").toString();

        enqueteService.creerEnqueteTel(name, texteAccroche, dateUtils.getDateFromString(dateString));
        return "index";
    }

    @RequestMapping(value = "/creerEnqueteInt", method = RequestMethod.GET)
    public ModelAndView creerEnquetIntGet(Map<String, Object> map,
                                          @ModelAttribute("enqueteInternet")EnqueteInternet enqueteInternet) {
        map.put("enqueteInternet", new EnqueteInternet());
        map.put("partenaires", partenaireService.recupererPartenaires());
        return new ModelAndView("proposer_enquete_int", map);
    }

    @RequestMapping(value = "/creerEnqueteInt", method = RequestMethod.POST)
    public String creerEnquetIntPost(@RequestParam Map<String, Object> map,
                                     @ModelAttribute("enqueteInternet") EnqueteInternet enqueteInternet,
                                     BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Echec");
            return "index";
        } else {
            String name = enqueteInternet.getName();
            String dateString = map.get("DATE").toString();
            System.out.println("nom enquête " + enqueteInternet.getName());
            System.out.println("Partenaire obtenu : " + enqueteInternet.getPartenaires());

            /** TODO Régler le problème de checkboxes proposer_enquete_int.jsp, en attendant, ajout
             * à la main de la liste des partenaires **/
            List<Partenaire> partenaireList =partenaireService.recupererPartenaires();

            enqueteService.creerEnqueteInt(name, dateUtils.getDateFromString(dateString), partenaireList);
            return "index";
        }
    }





    }
