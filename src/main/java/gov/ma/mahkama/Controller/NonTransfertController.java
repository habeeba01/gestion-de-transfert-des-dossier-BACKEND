package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.DescriptionDossierModel;
import gov.ma.mahkama.Model.DestinationDossierModel;
import gov.ma.mahkama.Model.NonTransfertModel;
import gov.ma.mahkama.Service.DossierService;
import gov.ma.mahkama.Service.NonTransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("nontransfert")
public class NonTransfertController {
    @Autowired
    private NonTransfertService nonTransfertService;

    @GetMapping("/all")
    public List<NonTransfertModel> findAll(){
        return nonTransfertService.findAll();
    }
    @GetMapping("/{destination}")
    public List<NonTransfertModel> find(@PathVariable String destination){
        return nonTransfertService.find(destination);
    }
    @PostMapping("/save")
    public NonTransfertModel save(@RequestBody NonTransfertModel nonTransfertModel){

        return nonTransfertService.save(nonTransfertModel);
    }
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return nonTransfertService.deleteDossier(id);
    }
    @PutMapping("/update")
    public NonTransfertModel update(@RequestBody NonTransfertModel nonTransfertModel){
        return nonTransfertService.updateDossier(nonTransfertModel);
    }
}
