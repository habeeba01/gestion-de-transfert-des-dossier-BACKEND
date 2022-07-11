package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.JugementDescriptionModel;
import gov.ma.mahkama.Model.JugementDestinationModel;
import gov.ma.mahkama.Repository.JugementDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationJugService {
    @Autowired
    private JugementDestinationRepository jugementDestinationRepository;

    public List<JugementDestinationModel> findAll(){
        return  jugementDestinationRepository.findAll();
    }
}
