package gov.ma.mahkama.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class DestinationDossierModel {
   // @Id @GeneratedValue(strategy = GenerationType.AUTO)
   // private Long id;
    @Id
    private String destination;

}
