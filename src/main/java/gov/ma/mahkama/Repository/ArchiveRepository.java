package gov.ma.mahkama.Repository;

import gov.ma.mahkama.Model.ArchiveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository @RepositoryRestResource
public interface ArchiveRepository extends JpaRepository<ArchiveModel,Long> {
}
