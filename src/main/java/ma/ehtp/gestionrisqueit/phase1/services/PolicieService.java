package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Maturity;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;

import java.util.List;
import java.util.Optional;

public interface PolicieService {
    public Policie save(Policie policie);
    public List<Policie> saveAll(List<Policie> policieList);
    public void deleteAll(List<Policie> policieList);
    public List<Policie> findByOrganization(Organization organization);
    public List<Policie> findByOrganizationAndPhase(Organization organization , Phase phase);

    public Optional<Policie> findById(Long id);
    public Integer countAllByOrganizationAndPhaseAndIsChecked(Organization organization , Phase phase , Boolean isChecked);

    public List<Policie> findByOrganizationAndPhaseAndIsChecked(Organization organization , Phase phase , Boolean isChecked);

}
