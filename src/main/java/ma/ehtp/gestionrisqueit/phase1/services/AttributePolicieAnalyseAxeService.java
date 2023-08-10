package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.dto.CalculationScore;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.AttributePolicieAnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;

import java.util.List;
import java.util.Optional;

public interface AttributePolicieAnalyseAxeService {
    public AttributePolicieAnalyseAxe save(AttributePolicieAnalyseAxe attributePolicieAnalyseAxe);
    public List<AttributePolicieAnalyseAxe> saveAll(List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxeList);
    public List<AttributePolicieAnalyseAxe> findByOrganization(Organization organization);
    public List<AttributePolicieAnalyseAxe> findByAnalyseAxe(AnalyseAxe analyseAxe);
    public List<AttributePolicieAnalyseAxe> findByPolicie(Policie policie);
    public List<AttributePolicieAnalyseAxe> findByPolicieAndAnalyseAxe(Policie policie , AnalyseAxe analyseAxe);
    public Optional<AttributePolicieAnalyseAxe> findById(Long id);
    public void deleteAll(List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxeList);
    public CalculationScore calculTheOverallScore(Organization organization);

    public List<List<AttributePolicieAnalyseAxe>> findByOrganizationAndPhase(Organization organization , Phase phase);
    public List<List<AttributePolicieAnalyseAxe>> findByOrganizationAndPhase2(Organization organization , Phase phase);
    public CalculationScore calculeScore(Organization organization ,Phase phase);
    public CalculationScore calculeScoreForPahse2(Organization organization ,Phase phase);

}
