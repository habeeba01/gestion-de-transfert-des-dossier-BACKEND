package gov.ma.mahkama.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionDossierModel  {
    @Id
    private String description;
    @ManyToOne @JoinColumn(name="idDestination")
    private DestinationDossierModel destinationDossierModel;

    public DescriptionDossierModel(String description) {
        this.description = description;
    }
}
