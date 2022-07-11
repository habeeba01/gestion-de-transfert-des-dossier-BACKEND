package gov.ma.mahkama.Security.SecModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AppRole {

    @Id
    @Column
    private String libelle;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Utilisateur> users = new ArrayList<>();


//constructeur
    public AppRole(String libelle){
        this.libelle = libelle;
    }

}
