package gov.ma.mahkama.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class JugementModel {
    //attribut
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Long numJugement;
    @Column  @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING) @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateJugement;
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.ALL)  @JoinColumn(name="idForcat")
    private ForcatModel forcatModel;
    @OneToOne @JoinColumn(name="description")
    private  JugementDescriptionModel jugementDescriptionModel;
    @OneToMany @Cascade(org.hibernate.annotations.CascadeType.ALL)  @JoinColumn(name="jugement")
    private List<AlgharamaModel> algharamaModels=new ArrayList<>();


}
