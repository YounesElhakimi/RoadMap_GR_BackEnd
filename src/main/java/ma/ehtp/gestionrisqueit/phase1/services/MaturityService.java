package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.Maturity;

import java.util.List;
import java.util.Optional;

public interface MaturityService {
    public Maturity save(Maturity maturity);
    public List<Maturity> saveAll(List<Maturity> maturityList);
    public void deleteAll(List<Maturity> maturityList);
    public List<Maturity> findByOrganization(Organization organization);
    public List<Maturity> findByOrganizationAndPhase(Organization organization , Phase phase);
    public Optional<Maturity> findById(Long id);
}
