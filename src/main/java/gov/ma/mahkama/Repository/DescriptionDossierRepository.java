package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.DescriptionDossierModel;
import gov.ma.mahkama.Model.DestinationDossierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository @RepositoryRestResource
public interface DescriptionDossierRepository extends JpaRepository<DescriptionDossierModel,Long> {
    List<DescriptionDossierModel> findByDescription(String id);
    List<DescriptionDossierModel> findAllByDestinationDossierModel(DestinationDossierModel destinationDossierModel);
}
