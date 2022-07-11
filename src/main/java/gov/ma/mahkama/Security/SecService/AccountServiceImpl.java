package gov.ma.mahkama.Security.SecService;

import gov.ma.mahkama.Model.JugementModel;
import gov.ma.mahkama.Security.SecModel.AppRole;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import gov.ma.mahkama.Security.SecRepository.RoleRepo;
import gov.ma.mahkama.Security.SecRepository.UtilisateurRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private RoleRepo roleRepo;
    private UtilisateurRepo utilisateurRepo;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(@Autowired RoleRepo roleRepo, @Autowired UtilisateurRepo utilisateurRepo, @Autowired PasswordEncoder passwordEncoder){
        this.roleRepo = roleRepo;
        this.utilisateurRepo = utilisateurRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Utilisateur addNewUser(Utilisateur user) {
        Utilisateur utilisateur=utilisateurRepo.findByUsername(user.getUsername());
      if(utilisateur!=null){
          System.out.println("this username already exists");
      }else{
          user.setPassword(passwordEncoder.encode(user.getPassword()));
          return utilisateurRepo.save(user);
      }
      return user;
    }
    @Override
    public AppRole addNewRole(AppRole appRole) {
        return roleRepo.save(appRole);
    }


    @Override
    public void affectRoleToUser(String username, String role) {
        Utilisateur user = utilisateurRepo.findByUsername(username);
        AppRole role1 = roleRepo.findByLibelle(role);
        user.getRoles().add(role1);
        role1.getUsers().add(user);
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return utilisateurRepo.findByUsername(username);
    }


    @Override
    public Utilisateur updatePassword(String username,String password) {
        Utilisateur utilisateur=utilisateurRepo.findByUsername(username);
        utilisateur.setPassword(passwordEncoder.encode(password));
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public List<Utilisateur> findALl() {
        return  utilisateurRepo.findAll();
    }

    @Override
    public List<AppRole> findAllRoles() {
        return  roleRepo.findAll();
    }

    @Override
    public String deleteUser(String id) {
        Utilisateur utilisateur=utilisateurRepo.findById(id).orElse(null);
        utilisateurRepo.delete(utilisateur);
        return id;
    }

}
