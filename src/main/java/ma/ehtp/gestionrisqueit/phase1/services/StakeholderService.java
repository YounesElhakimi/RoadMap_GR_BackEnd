package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Principle;
import ma.ehtp.gestionrisqueit.phase1.modelles.Stakeholder;

import java.util.List;
import java.util.Optional;

public interface StakeholderService {
    public Stakeholder save(Stakeholder stakeholder);
    public List<Stakeholder> saveAll(List<Stakeholder> stakeholderList);
    public void deleteAll(List<Stakeholder> stakeholderList);
    public List<Stakeholder> findByOrganization(Organization organization);
    public List<Stakeholder> findByOrganizationAndPhase(Organization organization, Phase  phase);

    public Optional<Stakeholder> findById(Long id);
}
