package ma.ehtp.gestionrisqueit.phase1.repositories;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Maturity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaturityRepository extends JpaRepository<Maturity, Long> {
    public List<Maturity> findByOrganization(Organization organization);
    public List<Maturity> findByOrganizationAndPhase(Organization organization , Phase phase);
    public Optional<Maturity> findById(Long id);

}
