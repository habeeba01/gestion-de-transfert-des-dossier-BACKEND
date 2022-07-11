package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.ArchiveModel;
import gov.ma.mahkama.Model.DescriptionDossierModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Model.NonTransfertModel;
import gov.ma.mahkama.Repository.DescriptionDossierRepository;
import gov.ma.mahkama.Repository.DestinationDossierRepository;
import gov.ma.mahkama.Repository.DossierRepository;
import gov.ma.mahkama.Repository.NonTransfertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class NonTransfertService {
    @Autowired
    private NonTransfertRepository nonTransfertRepository;
    @Autowired
    private DossierRepository dossierRepository;

  @Autowired
  private DescriptionDossierService descriptionDossierService;

    public List<NonTransfertModel> findAll(){
        return  nonTransfertRepository.findAll();
    }
    public NonTransfertModel save(NonTransfertModel nonTransfertModel){
        return nonTransfertRepository.save(nonTransfertModel);
    }
    public List<NonTransfertModel> find(String destinationDossierModel){
       List<DescriptionDossierModel> descriptionDossierModel=descriptionDossierService.find(destinationDossierModel);

        return nonTransfertRepository.findAllByDescriptionDossierModelIn( descriptionDossierModel);
    }
    public Long deleteDossier(Long id){
        NonTransfertModel nonTransfertModel=nonTransfertRepository.findById(id).orElse(null);
        DossierModel dossierModel=new DossierModel();
        dossierModel.setNumDossier(nonTransfertModel.getNumDossier());
        dossierModel.setJugementModel(nonTransfertModel.getJugementModel());
        dossierModel.setDescriptionDossierModel(nonTransfertModel.getDescriptionDossierModel());
        dossierModel.setDate(nonTransfertModel.getDate());

        dossierRepository.save(dossierModel);
        nonTransfertRepository.delete(nonTransfertModel);
        return id;
    }
    public NonTransfertModel updateDossier(NonTransfertModel dossierModel){
        NonTransfertModel dossierModel1=nonTransfertRepository.findById(dossierModel.getNumDossier()).orElse(null);
        dossierModel1.setNumDossier(dossierModel.getNumDossier());
        return nonTransfertRepository.save(dossierModel);
    }

}
