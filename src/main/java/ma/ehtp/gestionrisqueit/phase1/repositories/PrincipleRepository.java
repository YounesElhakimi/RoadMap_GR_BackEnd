package ma.ehtp.gestionrisqueit.phase1.repositories;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Principle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrincipleRepository extends JpaRepository<Principle, Long> {
    public   List<Principle> findByOrganization(Organization organization);
    public   List<Principle> findByOrganizationAndPhase(Organization organization , Phase phase);
    public Optional<Principle> findById(Long id);

}
