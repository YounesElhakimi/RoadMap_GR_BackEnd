package ma.ehtp.gestionrisqueit.phase1.services;

import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.dto.CalculationScore;
import ma.ehtp.gestionrisqueit.phase1.modelles.AnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.AttributePolicieAnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.modelles.Maturity;
import ma.ehtp.gestionrisqueit.phase1.modelles.Policie;
import ma.ehtp.gestionrisqueit.phase1.repositories.AnalyseAxeRepository;
import ma.ehtp.gestionrisqueit.phase1.repositories.AttributePolicieAnalyseAxeRepository;
import ma.ehtp.gestionrisqueit.phase1.repositories.PolicieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class AttributePolicieAnalyseAxeServiceImpl implements AttributePolicieAnalyseAxeService{

    @Autowired
    AttributePolicieAnalyseAxeRepository attributePolicieAnalyseAxeRepository;
    @Autowired
    PolicieRepository policieRepository;

    @Autowired
    AnalyseAxeRepository analyseAxeRepository;
    @Autowired
    MaturityService maturityService;
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

    @Override
    public List<List<AttributePolicieAnalyseAxe>> findByOrganizationAndPhase(Organization organization ,Phase phase){



        List<AttributePolicieAnalyseAxe> atrAxP = attributePolicieAnalyseAxeRepository.findByOrganizationAndPhase(organization,phase);
        if (atrAxP.isEmpty()){
            List<Policie> policies = policieRepository.findByOrganizationAndPhase(organization , phase);
            List<AnalyseAxe> analyseAxes = analyseAxeRepository.findByOrganizationAndPhaseAndIsChecked(organization,phase,true);
            for (Policie p :policies){
                for (AnalyseAxe a:analyseAxes){

                    AttributePolicieAnalyseAxe atr = new AttributePolicieAnalyseAxe();
                    atr.setAnalyseAxe(a);
                    atr.setPolicie(p);
                    atr.setOrganization(organization);
                    atr.setPhase(phase);
                    atr.setLevel(0);

                    attributePolicieAnalyseAxeRepository.save(atr);
                }
            }


        }

        List<List<AttributePolicieAnalyseAxe>> lists = new ArrayList();
        List<Policie> policies = policieRepository.findByOrganizationAndPhaseAndIsChecked(organization , phase , true);
        List<AnalyseAxe> analyseAxes = analyseAxeRepository.findByOrganizationAndPhaseAndIsChecked(organization,phase,true);
        for (Policie p :policies){
            List<AttributePolicieAnalyseAxe> list = new ArrayList<>();
            for (AnalyseAxe a:analyseAxes){
                list.add(
                        attributePolicieAnalyseAxeRepository.findByPolicieAndAnalyseAxe(p,a).get(0)
                );
            }
            lists.add(list);
        }



        return lists;
    }

    @Override
    public CalculationScore calculeScore(Organization organization, Phase phase) {
        CalculationScore calculationScore = new CalculationScore();
        Integer countLevel0 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,0);
        Integer countLevel1 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,1);
        Integer countLevel2 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,2);

        Integer sum = countLevel0 + countLevel1 + countLevel2;
        calculationScore.setNumber0(countLevel0);
        calculationScore.setNumber1(countLevel1);
        calculationScore.setNumber2(countLevel2);
        calculationScore.setPercentage0( ((double)  countLevel0/sum)*100);
        calculationScore.setPercentage1( ((double) countLevel1/sum)*100);
        calculationScore.setPercentage2( ((double) countLevel2/sum)*100);

        calculationScore.setOverallScore(countLevel0*0 + countLevel1*1 + countLevel2*2);
        calculationScore.setMaximumPossibleScore(sum*2);

        List<Maturity> maturityList = this.maturityService.findByOrganizationAndPhase(organization,phase);
        System.out.println("OverallScore : "+calculationScore.getOverallScore());

        for(Maturity m : maturityList){

            if ( (calculationScore.getOverallScore() >= m.getStar()) && (calculationScore.getOverallScore() <= m.getEnd())){
                calculationScore.setMaturityLevel(m.getLevel());
                break;
            }
        }


        return calculationScore;
    }

}
