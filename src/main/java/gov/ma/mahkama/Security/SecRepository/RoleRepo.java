package gov.ma.mahkama.Security.SecRepository;

import gov.ma.mahkama.Security.SecModel.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository @RepositoryRestResource
public interface RoleRepo extends JpaRepository<AppRole, String> {

    AppRole findByLibelle(String libelle);

}
