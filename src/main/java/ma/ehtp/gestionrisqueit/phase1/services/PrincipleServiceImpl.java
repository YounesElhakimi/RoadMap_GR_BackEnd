package ma.ehtp.gestionrisqueit.phase1.services;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Principle;
import ma.ehtp.gestionrisqueit.phase1.repositories.PrincipleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrincipleServiceImpl implements PrincipleService{
    @Autowired
    PrincipleRepository principleRepository;

    @Override
    public Principle save(Principle principle) {
        return principleRepository.save(principle);
    }

    @Override
    public List<Principle> saveAll(List<Principle> principleList) {
        return principleRepository.saveAll(principleList);
    }

    @Override
    public void deleteAll(List<Principle> principleList) {
        principleRepository.deleteAll(principleList);
    }

    @Override
    public List<Principle> findByOrganization(Organization organization) {
        return principleRepository.findByOrganization(organization);
    }

    @Override
    public List<Principle> findByOrganizationAndPhase(Organization organization, Phase phase) {
        return principleRepository.findByOrganizationAndPhase(organization,phase);
    }

    @Override
    public Optional<Principle> findById(Long id) {
        return principleRepository.findById(id);
    }
}
