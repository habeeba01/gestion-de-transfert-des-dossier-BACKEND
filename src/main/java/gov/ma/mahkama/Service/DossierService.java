package gov.ma.mahkama.Service;

import ch.qos.logback.classic.pattern.DateConverter;
import gov.ma.mahkama.Model.ArchiveModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Model.JugementModel;
import gov.ma.mahkama.Model.NonTransfertModel;
import gov.ma.mahkama.Repository.ArchiveRepository;
import gov.ma.mahkama.Repository.DossierRepository;
import gov.ma.mahkama.Repository.JugementRepository;
import gov.ma.mahkama.Repository.NonTransfertRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class DossierService {
    @Autowired
    private DossierRepository dossierRepository;
    @Autowired
    private ArchiveRepository archiveRepository;
    @Autowired
    private JugementRepository jugementRepository;
    @Autowired
    private NonTransfertRepository nonTransfertRepository;
    //
    public DossierModel save(DossierModel dossierModel){
        return dossierRepository.save(dossierModel);
    }
    //
    public List<DossierModel> findAll(DossierModel dossierModel){
        return dossierRepository.findAll();
    }
    //
    public Long deleteDossier(Long id){
        DossierModel dossierModel=dossierRepository.findById(id).orElse(null);
       // JugementModel jugementModel=jugementRepository.findById(dossierModel.getJugementModel().getNumJugement()).orElse(null);
         ArchiveModel archiveModel=new ArchiveModel();
       archiveModel.setNumDossier(dossierModel.getNumDossier());
       archiveModel.setJugementModel(dossierModel.getJugementModel());
       archiveModel.setDescriptionDossierModel(dossierModel.getDescriptionDossierModel());
       archiveModel.setDate(dossierModel.getDate());
      //  archiveModel.setUtilisateur(dossierModel.getUtilisateur());

     

        archiveRepository.save(archiveModel);
      //  jugementRepository.delete(jugementModel);
        dossierRepository.delete(dossierModel);
        return id;
    }
    //
    public DossierModel updateDossier(DossierModel dossierModel){
        DossierModel dossierModel1=dossierRepository.findById(dossierModel.getNumDossier()).orElse(null);
        dossierModel1.setNumDossier(dossierModel.getNumDossier());
        return dossierRepository.save(dossierModel);
    }
    //
    public Optional<DossierModel> findById(Long id) {

        return dossierRepository.findById(id);
    }

     public List<DossierModel> byDate(String start, String end) throws ParseException {
         Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(start);
         Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(end);
          new SimpleDateFormat("dd.MM.yyyy ").format(dateStart);
         new SimpleDateFormat("dd.MM.yyyy ").format(dateEnd);
        return dossierRepository.findByDateBetween(dateStart,dateEnd);
     }

}
