package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.ArchiveModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveService {
    @Autowired
    private ArchiveRepository archiveRepository;

    public List<ArchiveModel> findAll(){
        return archiveRepository.findAll();
    }
    //
    public Optional<ArchiveModel> findById(Long id) {

        return archiveRepository.findById(id);
    }
    public ArchiveModel save(ArchiveModel archiveModel){
        return this.archiveRepository.save(archiveModel);
    }
    public Long deleteDossier(Long id){
        ArchiveModel dossierModel=archiveRepository.findById(id).orElse(null);
        archiveRepository.delete(dossierModel);
        return id;
    }
}
