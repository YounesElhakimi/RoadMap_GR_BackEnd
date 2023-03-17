package ma.ehtp.gestionrisqueit.phase1.repositories;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolicieRepository extends JpaRepository<Policie , Long> {
    public List<Policie> findByOrganization(Organization organization);
    public List<Policie> findByOrganizationAndPhase(Organization organization , Phase phase);
    public List<Policie> findByOrganizationAndPhaseAndIsChecked(Organization organization , Phase phase , Boolean isChecked);
    public Optional<Policie> findById(Long id);
    public Integer countAllByOrganizationAndPhaseAndIsChecked(Organization organization , Phase phase , Boolean isChecked);

}
