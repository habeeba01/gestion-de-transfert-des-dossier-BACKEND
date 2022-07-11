package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.DestinationDossierModel;
import gov.ma.mahkama.Service.DestinationDossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("destination")
public class DestinationDossierController {
    @Autowired
    private DestinationDossierService destinationDossierService;

    @GetMapping("/")
    public List<DestinationDossierModel> findAll(){
        return destinationDossierService.listAll();
    }
}
