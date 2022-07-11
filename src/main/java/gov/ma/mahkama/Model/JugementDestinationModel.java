package gov.ma.mahkama.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class JugementDestinationModel {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;
    @Id
    private String destination;
}
