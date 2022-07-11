package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.ForcatModel;
import gov.ma.mahkama.Model.JugementDescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @RepositoryRestResource
public interface JugementDescriptionRepository extends JpaRepository<JugementDescriptionModel,Long> {
    Optional<JugementDescriptionModel> findById(Long id);
}
