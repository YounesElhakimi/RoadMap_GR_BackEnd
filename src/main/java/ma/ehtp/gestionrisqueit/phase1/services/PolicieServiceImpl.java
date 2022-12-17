package ma.ehtp.gestionrisqueit.phase1.services;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;
import ma.ehtp.gestionrisqueit.phase1.repositories.PolicieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicieServiceImpl implements PolicieService {

    @Autowired
    PolicieRepository policieRepository;

    @Override
    public Policie save(Policie policie) {
        return policieRepository.save(policie);
    }

    @Override
    public List<Policie> saveAll(List<Policie> policieList) {
        return policieRepository.saveAll(policieList);
    }

    @Override
    public void deleteAll(List<Policie> policieList) {
        policieRepository.deleteAll(policieList);
    }

    @Override
    public List<Policie> findByOrganization(Organization organization) {
        return policieRepository.findByOrganization(organization);
    }

    @Override
    public List<Policie> findByOrganizationAndPhase(Organization organization, Phase phase) {
        return policieRepository.findByOrganizationAndPhase(organization,phase);
    }

    @Override
    public Optional<Policie> findById(Long id) {
        return policieRepository.findById(id);
    }
}
