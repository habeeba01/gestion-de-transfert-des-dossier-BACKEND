package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.JugementDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @RepositoryRestResource
public interface JugementDestinationRepository extends JpaRepository<JugementDestinationModel,Long> {
    Optional<JugementDestinationModel> findById(Long id);
}
