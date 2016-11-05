package fr.humanbooster.enquetes.controller;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.EnqueteTelephone;
import fr.humanbooster.enquetes.service.EnqueteService;
import fr.humanbooster.enquetes.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    private HttpSession hSession;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/creerEnqueteTel", method = RequestMethod.GET)
    public ModelAndView creerEnqueteTelGet(@RequestParam Map<String, Object> map,
                                           @ModelAttribute("enqueteTelephone") EnqueteTelephone enqueteTelephone){
        map.put("enqueteTelephone", new EnqueteTelephone());
        return new ModelAndView("proposer_enquete_tel", map);
    }

    @RequestMapping(value = "/creerEnqueteTel", method = RequestMethod.POST)
    public String creerEnqueteTelPost(@ModelAttribute("enqueteTelephone") EnqueteTelephone enqueteTelephone) {

        String name = enqueteTelephone.getName();
        String texteAccroche = enqueteTelephone.getTexteAccroche();
        System.out.println("date récupérée : " + enqueteTelephone.getDateEnquete());

        enqueteService.creerEnquete(name, texteAccroche);
        return "index";
    }





}
