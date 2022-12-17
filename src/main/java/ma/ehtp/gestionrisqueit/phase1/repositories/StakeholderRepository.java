package ma.ehtp.gestionrisqueit.phase1.repositories;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Stakeholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StakeholderRepository extends JpaRepository<Stakeholder, Long> {
    public List<Stakeholder> findByOrganization(Organization organization);
    public Optional<Stakeholder> findById(Long id);
    List<Stakeholder> findByOrganizationAndPhase(Organization organization, Phase phase);
}
