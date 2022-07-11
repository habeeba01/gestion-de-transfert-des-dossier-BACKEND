package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.DescriptionDossierModel;
import gov.ma.mahkama.Service.DescriptionDossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("descDossier") @RestController
public class DescriptionDossierController {
    @Autowired
    private DescriptionDossierService descriptionDossierService;

    @GetMapping("/")
    public List<DescriptionDossierModel> findAll(){
        return descriptionDossierService.listAll();
    }
}
