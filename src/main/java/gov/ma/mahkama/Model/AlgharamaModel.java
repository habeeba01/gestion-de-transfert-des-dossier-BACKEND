package gov.ma.mahkama.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlgharamaModel {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Double montant;
    @Column
    private Double assaeir;


}
