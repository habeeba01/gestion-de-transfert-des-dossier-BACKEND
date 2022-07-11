package gov.ma.mahkama.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import gov.ma.mahkama.Security.SecModel.AppRole;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class DossierModel {
    //attribut
    @Id
    private Long numDossier;
    @Column  @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @OneToOne  @JoinColumn(name="description")
    private DescriptionDossierModel descriptionDossierModel;
    @OneToOne @Cascade(org.hibernate.annotations.CascadeType.ALL) @JoinColumn(name="Jugement")
    private JugementModel jugementModel;



}
