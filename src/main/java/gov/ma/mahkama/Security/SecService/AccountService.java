package gov.ma.mahkama.Security.SecService;

import gov.ma.mahkama.Security.SecModel.AppRole;
import gov.ma.mahkama.Security.SecModel.Utilisateur;

import java.util.List;

public interface AccountService {
    //insert
    Utilisateur addNewUser(Utilisateur user);
    AppRole addNewRole(AppRole appRole);
    void affectRoleToUser(String username, String role);
    //
   Utilisateur loadUserByUsername(String username);
    //
    Utilisateur updatePassword(String username,String password);
//
    List<Utilisateur> findALl();
    List<AppRole> findAllRoles();
    //
    String deleteUser(String id);

}
