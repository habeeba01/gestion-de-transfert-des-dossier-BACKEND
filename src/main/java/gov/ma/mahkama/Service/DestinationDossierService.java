package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.DestinationDossierModel;
import gov.ma.mahkama.Repository.DestinationDossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationDossierService {
    @Autowired
    private DestinationDossierRepository destinationDossierRepository;

    public List<DestinationDossierModel> listAll(){
        return destinationDossierRepository.findAll();
    }

    public DestinationDossierModel findBy(String destination){
        return destinationDossierRepository.findByDestination(destination);
    }
}
