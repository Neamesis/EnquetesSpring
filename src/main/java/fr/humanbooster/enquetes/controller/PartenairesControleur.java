package fr.humanbooster.enquetes.controller;

import fr.humanbooster.enquetes.service.PartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Nea on 05/11/2016.
 */
@Controller
public class PartenairesControleur {

    @Autowired
    private PartenaireService partenaireService;

    @Autowired
    private HttpSession hSession;

    @RequestMapping(value = "/genererPartenaires", method = RequestMethod.GET)
    public String creerPartenaires(){
        partenaireService.genererListePartenaires();
        return "partenaires_generes";
    }




}
