package gov.ma.mahkama.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity  @NoArgsConstructor @AllArgsConstructor @Data
public class ArchiveModel {
    //attribut
    //attribut
    @Id
    private Long numDossier;
    @Column  @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @OneToOne  @JoinColumn(name="description")
    private DescriptionDossierModel descriptionDossierModel;
    @OneToOne @Cascade(org.hibernate.annotations.CascadeType.ALL) @JoinColumn(name="Jugement")
    private JugementModel jugementModel;
    @OneToOne @JoinColumn(name="utilisateur")
    private Utilisateur utilisateur;

}
