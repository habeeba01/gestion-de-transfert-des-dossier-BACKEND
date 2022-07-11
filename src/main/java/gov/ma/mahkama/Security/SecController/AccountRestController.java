package gov.ma.mahkama.Security.SecController;

import gov.ma.mahkama.Security.SecDTOs.AffectRoleToUserDto;
import gov.ma.mahkama.Security.SecModel.AppRole;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import gov.ma.mahkama.Security.SecService.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("acc")

public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(@Autowired AccountService accountService){
        this.accountService = accountService;
    }


    @PostMapping("/save")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public Utilisateur saveUser(@RequestBody Utilisateur user){
        return this.accountService.addNewUser(user);
    }


    @PostMapping("/roletouser")
    public void affectRoleToUser(@RequestBody AffectRoleToUserDto affectRoleToUserDto){
        this.accountService.affectRoleToUser(affectRoleToUserDto.getUsername(), affectRoleToUserDto.getRole());
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') or hasAuthority('SUPERUSER')")
    public Utilisateur profile(Principal principal){
        return accountService.loadUserByUsername(principal.getName());
    }

    @PutMapping("/password/{username}/{password}") @CrossOrigin
    public Utilisateur updatePass(@PathVariable String username,@PathVariable String password){
        return accountService.updatePassword(username,password);
    }

    @GetMapping("AllUsers")
    public List<Utilisateur> findAll(){
        return accountService.findALl();
    }
    @GetMapping("AllRoles")
    public  List<AppRole> findRoles(){
        return accountService.findAllRoles();
    }
    @DeleteMapping("/{username}")
    public String delete(@PathVariable String username){
        return accountService.deleteUser(username);
    }
}