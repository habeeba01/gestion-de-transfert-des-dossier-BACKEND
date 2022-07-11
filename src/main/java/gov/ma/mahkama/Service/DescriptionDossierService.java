package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.DescriptionDossierModel;
import gov.ma.mahkama.Model.DestinationDossierModel;
import gov.ma.mahkama.Repository.DescriptionDossierRepository;
import gov.ma.mahkama.Repository.DestinationDossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionDossierService {
    @Autowired
    private DescriptionDossierRepository descriptionDossierModel;
    @Autowired
    private DestinationDossierRepository destinationDossierRepository;

    public List<DescriptionDossierModel> listAll(){
        return descriptionDossierModel.findAll();
    }
    public List<DescriptionDossierModel> findBy(String id){
        return descriptionDossierModel.findByDescription(id);
    }

    public List<DescriptionDossierModel> find(String destinationDossierModel){
       DestinationDossierModel destinationDossierModel1= destinationDossierRepository.findByDestination(destinationDossierModel);
       return descriptionDossierModel.findAllByDestinationDossierModel(destinationDossierModel1);
    }
}
