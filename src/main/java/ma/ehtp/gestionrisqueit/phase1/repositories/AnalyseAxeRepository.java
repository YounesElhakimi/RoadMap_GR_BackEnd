package ma.ehtp.gestionrisqueit.phase1.repositories;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnalyseAxeRepository extends JpaRepository<AnalyseAxe, Long> {
  public   List<AnalyseAxe> findByOrganization(Organization organization);
  public   List<AnalyseAxe> findByOrganizationAndPhase(Organization organization , Phase phase);
  public   List<AnalyseAxe> findByOrganizationAndPhaseAndIsChecked(Organization organization, Phase phase,Boolean isChecked);
  public Optional<AnalyseAxe> findById(Long id);

}
