package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.DossierModel;
import gov.ma.mahkama.Model.JugementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //@RepositoryRestResource
public interface JugementRepository extends JpaRepository<JugementModel,Long> {
    Optional<JugementModel> findById(Long id);
}
