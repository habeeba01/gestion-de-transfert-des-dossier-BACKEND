package gov.ma.mahkama.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class JugementDescriptionModel {
  //  @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id;
    @Id
    private String description;
    @ManyToOne @JoinColumn(name="idJugementDestination")
    private JugementDestinationModel jugementDestinationModel;

  public JugementDescriptionModel(String description) {
    this.description = description;
  }
}
