package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.repositories.AnalyseAxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class AnalyseAxeServiceImpl implements AnalyseAxeService{
    @Autowired
    AnalyseAxeRepository analyseAxeRepository;
    @Override
    public AnalyseAxe save(AnalyseAxe analyseAxe) {
        return null;
    }

    @Override
    public List<AnalyseAxe> saveAll(List<AnalyseAxe> analyseAxeList) {

        return analyseAxeRepository.saveAll(analyseAxeList);
    }

    @Override
    public List<AnalyseAxe> findByOrganization(Organization organization) {
        return null;
    }

    @Override
    public Optional<AnalyseAxe> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteAll(List<AnalyseAxe> analyseAxeList) {

    }

    @Override
    public List<AnalyseAxe> findByOrganizationAndPhaseAndIsChecked(Organization organization, Phase phase, Boolean isChecked) {
        return analyseAxeRepository.findByOrganizationAndPhaseAndIsChecked(organization,phase,isChecked);
    }

    @Override
    public List<AnalyseAxe> findByOrganizationAndPhase(Organization organization, Phase phase) {
        return analyseAxeRepository.findByOrganizationAndPhase(organization,phase);
    }
}
