package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase1.dto.CalculationScore;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.AttributePolicieAnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;
import ma.ehtp.gestionrisqueit.phase1.repositories.AttributePolicieAnalyseAxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class AttributePolicieAnalyseAxeServiceImpl implements AttributePolicieAnalyseAxeService{

    @Autowired
    AttributePolicieAnalyseAxeRepository attributePolicieAnalyseAxeRepository;
    @Override
    public AttributePolicieAnalyseAxe save(AttributePolicieAnalyseAxe attributePolicieAnalyseAxe) {
        return attributePolicieAnalyseAxeRepository.save(attributePolicieAnalyseAxe);
    }

    @Override
    public List<AttributePolicieAnalyseAxe> saveAll(List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxeList) {
        return attributePolicieAnalyseAxeRepository.saveAll(attributePolicieAnalyseAxeList);
    }

    @Override
    public List<AttributePolicieAnalyseAxe> findByOrganization(Organization organization) {
        return attributePolicieAnalyseAxeRepository.findByOrganization(organization);
    }

    @Override
    public List<AttributePolicieAnalyseAxe> findByAnalyseAxe(AnalyseAxe analyseAxe) {
        return attributePolicieAnalyseAxeRepository.findByAnalyseAxe(analyseAxe);
    }

    @Override
    public List<AttributePolicieAnalyseAxe> findByPolicie(Policie policie) {
        return attributePolicieAnalyseAxeRepository.findByPolicie(policie);
    }

    @Override
    public List<AttributePolicieAnalyseAxe> findByPolicieAndAnalyseAxe(Policie policie, AnalyseAxe analyseAxe) {
        return attributePolicieAnalyseAxeRepository.findByPolicieAndAnalyseAxe(policie,analyseAxe);
    }

    @Override
    public Optional<AttributePolicieAnalyseAxe> findById(Long id) {
        return attributePolicieAnalyseAxeRepository.findById(id);
    }

    @Override
    public void deleteAll(List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxeList) {
        attributePolicieAnalyseAxeRepository.deleteAll(attributePolicieAnalyseAxeList);
    }

    @Override
    public CalculationScore calculTheOverallScore(Organization organization) {
        return null;
    }
}
