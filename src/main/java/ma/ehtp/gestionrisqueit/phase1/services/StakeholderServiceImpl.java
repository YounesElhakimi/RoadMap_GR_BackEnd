package ma.ehtp.gestionrisqueit.phase1.services;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Stakeholder;
import ma.ehtp.gestionrisqueit.phase1.repositories.StakeholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StakeholderServiceImpl implements StakeholderService {

    @Autowired
    StakeholderRepository stakeholderRepository;


    @Override
    public Stakeholder save(Stakeholder stakeholder) {
        return stakeholderRepository.save(stakeholder);
    }

    @Override
    public List<Stakeholder> saveAll(List<Stakeholder> stakeholderList) {
        return stakeholderRepository.saveAll(stakeholderList);
    }

    @Override
    public void deleteAll(List<Stakeholder> stakeholderList) {
        stakeholderRepository.deleteAll(stakeholderList);
    }

    @Override
    public List<Stakeholder> findByOrganization(Organization organization) {
        return stakeholderRepository.findByOrganization(organization);
    }

    @Override
    public List<Stakeholder> findByOrganizationAndPhase(Organization organization, Phase phase) {
        return stakeholderRepository.findByOrganizationAndPhase(organization,phase);
    }

    @Override
    public Optional<Stakeholder> findById(Long id) {
        return stakeholderRepository.findById(id);
    }
}
