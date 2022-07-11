package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.ArchiveModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Repository.AlgharamaRepository;
import gov.ma.mahkama.Repository.ArchiveRepository;
import gov.ma.mahkama.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlgharamaService {
    @Autowired
   private AlgharamaRepository algharamaRepository;
    //
    public AlgharamaModel save(AlgharamaModel dossierModel){
        return algharamaRepository.save(dossierModel);
    }
    //
    public List<AlgharamaModel > findAll(AlgharamaModel  dossierModel){
        return algharamaRepository.findAll();
    }
    //
    public Long deleteDossier(Long id){
        AlgharamaModel  dossierModel=algharamaRepository.findById(id).orElse(null);
        algharamaRepository.delete(dossierModel);
        return id;
    }
    //
    public AlgharamaModel updateDossier(AlgharamaModel  dossierModel){
        AlgharamaModel  dossierModel1=algharamaRepository.findById(dossierModel.getId()).orElse(null);
        dossierModel1.setId(dossierModel.getId());
        return algharamaRepository.save(dossierModel);
    }
    //
    public Optional<AlgharamaModel > findById(Long id) {

        return algharamaRepository.findById(id);
    }


}
