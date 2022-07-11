package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.JugementDescriptionModel;
import gov.ma.mahkama.Repository.JugementDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionJugService {
    @Autowired
    private JugementDescriptionRepository jugementDescriptionRepository;

    public List<JugementDescriptionModel> findAll(){
       return  jugementDescriptionRepository.findAll();
    }
}
