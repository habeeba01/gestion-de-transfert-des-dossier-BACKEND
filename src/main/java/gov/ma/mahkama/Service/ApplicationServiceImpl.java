package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Repository.AlgharamaRepository;
import gov.ma.mahkama.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
    AlgharamaRepository algharamaRepository;
    @Autowired
    DossierRepository dossierRepository;

    @Override
    public Double totale(AlgharamaModel algharamaModel) {
        return algharamaModel.getAssaeir()+algharamaModel.getMontant();
    }
    @Override
    public Double totaleById(Long id) {
        AlgharamaModel dossierModel=algharamaRepository.findById(id).orElse(null);
        return dossierModel.getAssaeir()+dossierModel.getMontant();
    }


}
