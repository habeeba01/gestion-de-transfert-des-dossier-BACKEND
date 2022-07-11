package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.AlgharamaModel;
import gov.ma.mahkama.Model.ForcatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //@RepositoryRestResource
public interface AlgharamaRepository extends JpaRepository<AlgharamaModel,Long> {
    Optional<AlgharamaModel> findById(Long id);
}
