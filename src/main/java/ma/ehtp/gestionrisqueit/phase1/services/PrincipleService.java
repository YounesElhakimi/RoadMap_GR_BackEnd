package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;
import ma.ehtp.gestionrisqueit.phase1.modelles.Principle;

import java.util.List;
import java.util.Optional;

public interface PrincipleService {
    public Principle save(Principle principle);
    public List<Principle> saveAll(List<Principle> principleList);
    public void deleteAll(List<Principle> principleList);
    public List<Principle> findByOrganization(Organization organization);
    public   List<Principle> findByOrganizationAndPhase(Organization organization , Phase phase);
    public Optional<Principle> findById(Long id);
}
