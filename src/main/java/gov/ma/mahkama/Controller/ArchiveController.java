package gov.ma.mahkama.Controller;

import gov.ma.mahkama.Model.ArchiveModel;
import gov.ma.mahkama.Service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("archive")
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;

    @GetMapping("/all")
    public List<ArchiveModel> findAll(){
        return archiveService.findAll();
    }
    @GetMapping("{id}")
    public Optional<ArchiveModel> byId(@PathVariable Long id){
        return archiveService.findById(id);
    }
    @PostMapping("/save")
    public ArchiveModel save(@RequestBody ArchiveModel archiveModel){
        return  archiveService.save(archiveModel);
    }
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return archiveService.deleteDossier(id);
    }
}
