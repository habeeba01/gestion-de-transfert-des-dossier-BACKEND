package gov.ma.mahkama.Service;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Model.JugementModel;

import java.util.Date;
import java.util.List;

public interface ApplicationService {
 Double totale(AlgharamaModel algharamaModel);
 Double totaleById(Long id);

}
