package ma.ehtp.gestionrisqueit.phase1.repositories;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.AttributePolicieAnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttributePolicieAnalyseAxeRepository extends JpaRepository<AttributePolicieAnalyseAxe, Long> {
 
    public List<AttributePolicieAnalyseAxe> findByOrganization(Organization organization);
    public List<AttributePolicieAnalyseAxe> findByAnalyseAxe(AnalyseAxe analyseAxe);
    public List<AttributePolicieAnalyseAxe> findByPolicie(Policie policie);
    public List<AttributePolicieAnalyseAxe> findByPolicieAndAnalyseAxe(Policie policie , AnalyseAxe analyseAxe);
    public Optional<AttributePolicieAnalyseAxe> findById(Long id);
}
