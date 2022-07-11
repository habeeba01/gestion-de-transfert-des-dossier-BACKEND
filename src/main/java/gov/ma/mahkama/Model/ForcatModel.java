package gov.ma.mahkama.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//المحكوم عليه
@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class ForcatModel {
    //attribut
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id ;
  @Column
    private String cin ;
    @Column
    private String nom ;


}
