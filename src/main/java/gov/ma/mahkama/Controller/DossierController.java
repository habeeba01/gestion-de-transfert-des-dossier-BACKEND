package gov.ma.mahkama.Controller;


import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Service.DossierService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("dossier")
public class DossierController {
    @Autowired
    private DossierService dossierService;

    //add
    @PostMapping("/add")
    public DossierModel save( @RequestBody DossierModel dossierModel){
        return dossierService.save(dossierModel);
    }
//all
    @GetMapping("/all")
    public List<DossierModel> findAll(DossierModel dossierModel){
        return dossierService.findAll(dossierModel);
    }
    //delete
    @DeleteMapping("/{id}") @CrossOrigin(methods = {RequestMethod.DELETE})
    public Long deleteDossier(@PathVariable Long id){
        return dossierService.deleteDossier(id);
    }
   //find by id
    @GetMapping("/{id}")
    public Optional<DossierModel> findById(@PathVariable Long id){
        return dossierService.findById(id);
    }

    //
    @PutMapping("/update")
    public DossierModel updateDossier(@RequestBody DossierModel dossierModel) {
        return dossierService.updateDossier(dossierModel);

    }
     @SneakyThrows
     @GetMapping("/date/{start}/{end}")
    public List<DossierModel> byDate(@PathVariable String start,@PathVariable String end){
        return dossierService.byDate(start,end);
    }
}
