package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Service.AlgharamaService;
import gov.ma.mahkama.Service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("algharama")
public class AlgharamaController {
    @Autowired
    private AlgharamaService dossierService;

    //add
    @PostMapping("/add")
    public AlgharamaModel save(@Valid @RequestBody AlgharamaModel  dossierModel){
        return dossierService.save(dossierModel);
    }
    //all
    @GetMapping("/all")
    public List<AlgharamaModel > findAll(AlgharamaModel  dossierModel){
        return dossierService.findAll(dossierModel);
    }
    //delete
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return dossierService.deleteDossier(id);
    }
    //find by id
    @GetMapping("/{id}")
    public Optional<AlgharamaModel > findById(@PathVariable Long id){
        return dossierService.findById(id);
    }

    //
    @PutMapping("/update")
    public AlgharamaModel  update(@RequestBody AlgharamaModel  dossierModel) {
        return dossierService.updateDossier(dossierModel);

    }
}
