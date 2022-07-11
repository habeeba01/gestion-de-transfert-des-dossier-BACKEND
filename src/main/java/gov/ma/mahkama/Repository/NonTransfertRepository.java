package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.DescriptionDossierModel;
import gov.ma.mahkama.Model.NonTransfertModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository @RepositoryRestResource
public interface NonTransfertRepository extends JpaRepository<NonTransfertModel,Long> {
    List<NonTransfertModel> findAllByDescriptionDossierModelIn(Iterable<DescriptionDossierModel> descriptionDossierModel);
}
