package fr.humanbooster.enquetes.controller;

import fr.humanbooster.enquetes.business.Enquete;
import fr.humanbooster.enquetes.business.Partenaire;
import fr.humanbooster.enquetes.service.EnqueteService;
import fr.humanbooster.enquetes.service.PartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static fr.humanbooster.enquetes.controller.EnquetesControleur.TRI_PAR_DEFAUT;

/**
 * Created by Nea on 05/11/2016.
 */
@Controller
public class PartenairesControleur {

    @Autowired
    private PartenaireService partenaireService;

    @Autowired
    private EnqueteService enqueteService;

    @Autowired
    private HttpSession hSession;


    @RequestMapping(value = "/genererPartenaires", method = RequestMethod.GET)
    public String creerPartenaires(){
        partenaireService.genererListePartenaires();
        return "partenaires_generes";
    }

    @RequestMapping(value = "creerPartenaire", method = RequestMethod.GET)
    public ModelAndView creerPartenaireGet(@ModelAttribute("partenaire") Partenaire partenaire) {
        ModelAndView mav = new ModelAndView("creer_partenaire");
        List<Partenaire> partenaires = partenaireService.recupererPartenaires();
        mav.addObject("partenaire", new Partenaire());
        mav.addObject("partenaires", partenaires);
        return mav;
    }

    @RequestMapping(value = "creerPartenaire", method = RequestMethod.POST)
    public ModelAndView creerPartenairePost(@ModelAttribute("partenaire") Partenaire partenaire) {
        System.out.println("ModelAttribute récupéré : " + partenaire);
        String namePartenaire = partenaire.getNamePartenaire();
        String siteWeb = partenaire.getSiteWebPartenaire();
        partenaireService.creerPartenaire(namePartenaire, siteWeb);
        ModelAndView mav = new ModelAndView("index");
        List<Enquete> enquetes = enqueteService.recupererEnquetesTriees(EnquetesControleur.TRI_PAR_DEFAUT);
        mav.addObject("enquetes", enquetes);
        return mav;
    }

}
