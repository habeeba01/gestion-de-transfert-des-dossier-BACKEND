package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Repository.AlgharamaRepository;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import gov.ma.mahkama.Service.ApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("app")
public class ApplicationController {
    @Autowired
    ApplicationServiceImpl applicationService;



    @GetMapping("/")
    public Double Totale(@RequestBody AlgharamaModel algharamaModel){
        return applicationService.totale(algharamaModel);
    }
    @GetMapping("/{id}")
    public Double totaleById(@PathVariable Long id){
        return applicationService.totaleById(id);
    }


}
