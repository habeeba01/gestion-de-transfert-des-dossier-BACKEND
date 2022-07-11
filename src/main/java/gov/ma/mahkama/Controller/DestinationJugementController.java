package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.DestinationDossierModel;
import gov.ma.mahkama.Model.JugementDestinationModel;
import gov.ma.mahkama.Service.DestinationJugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("destinationJug")
public class DestinationJugementController {
    @Autowired
    private DestinationJugService destinationJugService;
    @GetMapping("/")
    public List<JugementDestinationModel> findAll(){
        return  destinationJugService.findAll();
    }
}
