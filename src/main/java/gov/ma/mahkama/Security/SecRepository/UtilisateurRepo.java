package gov.ma.mahkama.Security.SecRepository;

import gov.ma.mahkama.Security.SecModel.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository @RepositoryRestResource
public interface UtilisateurRepo extends JpaRepository<Utilisateur, String> {

    Utilisateur findByUsername(String username);


}
