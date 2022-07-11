package gov.ma.mahkama;

import gov.ma.mahkama.Security.SecModel.AppRole;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import gov.ma.mahkama.Security.SecService.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@SpringBootApplication @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) @CrossOrigin(origins = "http://localhost:4200")

public class MahkamaApplication {

	public static void main(String[] args) {

		SpringApplication.run(MahkamaApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.addNewRole(new AppRole("ADMIN"));
			accountService.addNewRole(new AppRole("USER"));
			accountService.addNewRole(new AppRole("SUPERUSER"));
			//accountService.addNewUser(new Utilisateur("habiba", "habiba", new ArrayList<>()));
			accountService.addNewUser(new Utilisateur("admin", "admin", new ArrayList<>()));
		//	accountService.affectRoleToUser("habiba", "USER");
			accountService.affectRoleToUser("admin", "ADMIN");

		};
	}
}
