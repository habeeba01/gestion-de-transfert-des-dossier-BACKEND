package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.JugementDescriptionModel;
import gov.ma.mahkama.Service.DescriptionJugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("descJug")
public class DescriptionJugementController {
    @Autowired
    private DescriptionJugService descriptionJugService;

    @GetMapping("/")
    public List<JugementDescriptionModel> listAll(){
        return descriptionJugService.findAll();
    }
}
