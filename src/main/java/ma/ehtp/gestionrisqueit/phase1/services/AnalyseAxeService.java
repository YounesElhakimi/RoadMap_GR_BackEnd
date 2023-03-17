package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;

import java.util.List;
import java.util.Optional;

public interface AnalyseAxeService {
    public AnalyseAxe save(AnalyseAxe analyseAxe);
    public List<AnalyseAxe> saveAll(List<AnalyseAxe> analyseAxeList);
    public List<AnalyseAxe> findByOrganization(Organization organization);
    public Optional<AnalyseAxe> findById(Long id);
    public void deleteAll(List<AnalyseAxe> analyseAxeList);
    public   List<AnalyseAxe> findByOrganizationAndPhaseAndIsChecked(Organization organization, Phase phase, Boolean isChecked);
    public   List<AnalyseAxe> findByOrganizationAndPhase(Organization organization , Phase phase);
    public Integer countAllByOrganizationAndPhaseAndIsChecked(Organization organization , Phase phase , Boolean isChecked);


}
