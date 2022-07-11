package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.DossierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository @RepositoryRestResource
public interface DossierRepository extends JpaRepository<DossierModel,Long> {

    Optional<DossierModel> findById(Long id);
  //  @Query(value = "SELECT * FROM dossier_model WHERE date BETWEEN start AND end")
    List<DossierModel> findByDateBetween(Date start,Date end);
}
