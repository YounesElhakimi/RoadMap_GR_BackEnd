package ma.ehtp.gestionrisqueit.phase1.modelles;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder=true)

public class AttributePolicieAnalyseAxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Phase phase;

    @OneToOne
    private Policie policie;

    @OneToOne
    private AnalyseAxe analyseAxe;

    private Integer level;

    @ManyToOne
    private Organization organization;
}
