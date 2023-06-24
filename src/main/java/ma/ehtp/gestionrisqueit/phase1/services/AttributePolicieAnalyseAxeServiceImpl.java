package ma.ehtp.gestionrisqueit.phase1.services;

import io.swagger.models.auth.In;
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
import java.util.stream.Collectors;


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

    /*
    @Override
    public List<List<AttributePolicieAnalyseAxe>> findByOrganizationAndPhase(Organization organization ,Phase phase){


        List<AttributePolicieAnalyseAxe> atrAxP = attributePolicieAnalyseAxeRepository.findByOrganizationAndPhase(organization,phase);
        if (atrAxP.isEmpty()){
            List<Policie> policies = policieRepository.findByOrganizationAndPhase(organization , phase);
            List<AnalyseAxe> analyseAxes = analyseAxeRepository.findByOrganizationAndPhaseAndIsChecked(organization,phase,true);
            if (phase != Phase.PHASE2)
                for (Policie p :policies){
                    Integer firstInitLevel = 0;
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
            else
                for (Policie p :policies){
                    Integer firstInitLevel = -1;
                    if (p.getIsChecked()){
                         firstInitLevel = 0;
                    }
                    for (AnalyseAxe a:analyseAxes){

                        AttributePolicieAnalyseAxe atr = new AttributePolicieAnalyseAxe();
                        atr.setAnalyseAxe(a);
                        atr.setPolicie(p);
                        atr.setOrganization(organization);
                        atr.setPhase(phase);
                        atr.setLevel(firstInitLevel);
                        firstInitLevel = -1;
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


     */

    @Override
    public List<List<AttributePolicieAnalyseAxe>> findByOrganizationAndPhase(Organization organization ,Phase phase){


        List<AttributePolicieAnalyseAxe> atrAxP = attributePolicieAnalyseAxeRepository.findByOrganizationAndPhase(organization,phase);
        if (atrAxP.isEmpty()){
            List<Policie> policies = policieRepository.findByOrganizationAndPhase(organization , phase);
            List<AnalyseAxe> analyseAxes = analyseAxeRepository.findByOrganizationAndPhase(organization,phase);
                for (Policie p :policies){
                    Integer firstInitLevel = 0;
                    for (AnalyseAxe a:analyseAxes){

                        AttributePolicieAnalyseAxe atr = new AttributePolicieAnalyseAxe();
                        atr.setAnalyseAxe(a);
                        atr.setPolicie(p);
                        atr.setOrganization(organization);
                        atr.setPhase(phase);
                        atr.setLevel(-1);
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
                AttributePolicieAnalyseAxe apax = attributePolicieAnalyseAxeRepository.findByPolicieAndAnalyseAxe(p,a).get(0);
                if (apax == null){
                    apax =    attributePolicieAnalyseAxeRepository.save(
                            new AttributePolicieAnalyseAxe(null,a.getPhase(),p,a,0,a.getOrganization())
                    );
                }

                if (apax.getLevel() == -1)
                    apax.setLevel(0);
                list.add(
                        apax.toBuilder().build()
                );
            }
            lists.add(list);
        }
        System.out.println(lists.get(0).get(0).getLevel());
        atrAxP.forEach((a)-> a.setLevel(-1));
        System.out.println(lists.get(0).get(0).getLevel());

        this.attributePolicieAnalyseAxeRepository.saveAll(atrAxP);
        this.attributePolicieAnalyseAxeRepository.saveAll(lists.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList()));

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

        Double overallScore =Double.valueOf(countLevel0*0 + countLevel1*1 + countLevel2*2);
        calculationScore.setOverallScore(overallScore);
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


    @Override
    public CalculationScore calculeScoreForPahse2(Organization organization, Phase phase) {
        CalculationScore calculationScore = new CalculationScore();
        List<AttributePolicieAnalyseAxe> axeList = attributePolicieAnalyseAxeRepository.findByOrganizationAndPhase(organization,phase);
        Integer countLevel0 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,0);
        Integer countLevel1 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,1);
        Integer countLevel2 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,2);
        Integer countLevel3 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,3);
        Integer countLevel4 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,4);
        Integer countLevel5 = attributePolicieAnalyseAxeRepository.countAllByOrganizationAndPhaseAndLevel(organization,phase,5);
        System.out.println(countLevel0);
        System.out.println(countLevel1);
        System.out.println(countLevel2);
        System.out.println(countLevel3);
        System.out.println(countLevel4);
        System.out.println(countLevel5);
        Integer sum = countLevel0 + countLevel1 + countLevel2 + countLevel3 + countLevel4 + countLevel5;
        calculationScore.setNumber0(countLevel0);
        calculationScore.setNumber1(countLevel1);
        calculationScore.setNumber2(countLevel2);
        calculationScore.setNumber3(countLevel3);
        calculationScore.setNumber4(countLevel4);
        calculationScore.setNumber5(countLevel5);
        calculationScore.setPercentage0( ((double)  countLevel0/sum)*100);
        calculationScore.setPercentage1( ((double) countLevel1/sum)*100);
        calculationScore.setPercentage2( ((double) countLevel2/sum)*100);
        calculationScore.setPercentage3( ((double) countLevel3/sum)*100);
        calculationScore.setPercentage4( ((double) countLevel4/sum)*100);
        calculationScore.setPercentage5( ((double) countLevel5/sum)*100);

        calculationScore.setMaximumPossibleScore(sum*2);

        Double overallScor =  0.0;
        for (AttributePolicieAnalyseAxe a : axeList){
            if (a.getLevel() < 0) continue;
            if (a.getPolicie().getNum() == 1 || a.getPolicie().getNum() == 2 ){
                overallScor += 0.6 * a.getLevel();
                continue;
            }
            overallScor += 0.4 * a.getLevel();
        }
        overallScor = overallScor/14;
        calculationScore.setOverallScore(overallScor);

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
