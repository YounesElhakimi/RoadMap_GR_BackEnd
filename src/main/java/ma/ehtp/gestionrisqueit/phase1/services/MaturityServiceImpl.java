package ma.ehtp.gestionrisqueit.phase1.services;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.Maturity;
import ma.ehtp.gestionrisqueit.phase1.repositories.MaturityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaturityServiceImpl implements MaturityService{
    @Autowired
    MaturityRepository maturityRepository;
    @Override
    public Maturity save(Maturity maturity) {
        return maturityRepository.save(maturity);
    }

    @Override
    public List<Maturity> saveAll(List<Maturity> maturityList) {
        return maturityRepository.saveAll(maturityList);
    }

    @Override
    public void deleteAll(List<Maturity> maturityList) {
        maturityRepository.deleteAll(maturityList);
    }

    @Override
    public List<Maturity> findByOrganization(Organization organization) {
        return maturityRepository.findByOrganization(organization);
    }

    @Override
    public List<Maturity> findByOrganizationAndPhase(Organization organization, Phase phase) {
        return maturityRepository.findByOrganizationAndPhase(organization,phase);
    }


    @Override
    public Optional<Maturity> findById(Long id)
    {
        return maturityRepository.findById(id);
    }
}
