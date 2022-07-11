package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Model.ForcatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @RepositoryRestResource
public interface ForcatRepository extends JpaRepository<ForcatModel,Long> {
    Optional<ForcatModel> findById(Long id);
}
