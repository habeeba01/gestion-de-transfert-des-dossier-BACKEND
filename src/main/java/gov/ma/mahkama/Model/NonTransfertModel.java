package gov.ma.mahkama.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class NonTransfertModel {
    //attribut
    @Id
    private Long numDossier;
    @Column @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @OneToOne
    @JoinColumn(name="description")
    private DescriptionDossierModel descriptionDossierModel;
    @OneToOne @Cascade(org.hibernate.annotations.CascadeType.ALL) @JoinColumn(name="Jugement") @JsonIgnore
    private JugementModel jugementModel;
}
