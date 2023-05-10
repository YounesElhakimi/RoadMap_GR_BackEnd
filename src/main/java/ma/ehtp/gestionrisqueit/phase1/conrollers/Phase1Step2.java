package ma.ehtp.gestionrisqueit.phase1.conrollers;


import ma.ehtp.gestionrisqueit.phase0.conrollers.InitOrg;
import ma.ehtp.gestionrisqueit.phase0.messages.ResponseMessage;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase1.dto.CalculationScore;
import ma.ehtp.gestionrisqueit.phase1.modelles.AttributePolicieAnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.services.AttributePolicieAnalyseAxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Phase1Step2  extends InitOrg {
    @Autowired
    AttributePolicieAnalyseAxeService attributePolicieAnalyseAxeService;

    //Sub-step 2.1
    @GetMapping("/{phase}/AttributePolicieAnalyseAxe")
    public ResponseEntity<List<List<AttributePolicieAnalyseAxe>>> getAttributePolicieAnalyseAxe(HttpSession session ,@PathVariable String phase){
        initOrg(session);
        List<List<AttributePolicieAnalyseAxe>> attributePolicieAnalyseAxes = attributePolicieAnalyseAxeService.findByOrganizationAndPhase(organization , Phase.valueOf(phase.toUpperCase()));
        return ResponseEntity.status(HttpStatus.OK).body(attributePolicieAnalyseAxes);
    }

    @PostMapping("/{phase}/AttributePolicieAnalyseAxe")
    public ResponseEntity<ResponseMessage> postAttributePolicieAnalyseAxe(@RequestBody List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxes ,@PathVariable String phase, HttpSession session){
        initOrg(session);

        String message ="";

        try {


            attributePolicieAnalyseAxes.forEach(attributePolicieAnalyseAxe -> {
                attributePolicieAnalyseAxe.setOrganization(organization);
            });

            attributePolicieAnalyseAxeService.saveAll(attributePolicieAnalyseAxes);
            message = "save successfully: ";

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }


    //Sub-step 2.2
    @GetMapping("/{phase}/calculation_of_the_overall_score")
    public ResponseEntity<CalculationScore> getCalculationScore(HttpSession session , @PathVariable String phase){
        initOrg(session);
        CalculationScore calculationScore = null;
        if (Phase.valueOf(phase.toUpperCase()) == Phase.PHASE2)
         calculationScore = attributePolicieAnalyseAxeService.calculeScoreForPahse2(organization , Phase.valueOf(phase.toUpperCase()));
       else
         calculationScore = attributePolicieAnalyseAxeService.calculeScore(organization , Phase.valueOf(phase.toUpperCase()));

        System.out.println("calculationScore "+ calculationScore);
        return ResponseEntity.status(HttpStatus.OK).body(calculationScore);
    }


    //Sub-step 3.1

}


