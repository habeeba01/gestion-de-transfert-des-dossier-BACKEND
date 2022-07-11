package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.DestinationDossierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository @RepositoryRestResource
public interface DestinationDossierRepository extends JpaRepository<DestinationDossierModel,Long> {
    DestinationDossierModel findByDestination(String id);
}
