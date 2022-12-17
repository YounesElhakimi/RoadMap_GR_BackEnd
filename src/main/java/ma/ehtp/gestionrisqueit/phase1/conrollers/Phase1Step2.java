package ma.ehtp.gestionrisqueit.phase1.conrollers;


import ma.ehtp.gestionrisqueit.phase0.conrollers.InitOrg;
import ma.ehtp.gestionrisqueit.phase0.messages.ResponseMessage;
import ma.ehtp.gestionrisqueit.phase1.dto.CalculationScore;
import ma.ehtp.gestionrisqueit.phase1.modelles.AttributePolicieAnalyseAxe;
import ma.ehtp.gestionrisqueit.phase1.services.AttributePolicieAnalyseAxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class Phase1Step2  extends InitOrg {
    @Autowired
    AttributePolicieAnalyseAxeService attributePolicieAnalyseAxeService;

    //Sub-step 2.1
    @GetMapping("/AttributePolicieAnalyseAxe")
    public ResponseEntity<List<AttributePolicieAnalyseAxe>> getAttributePolicieAnalyseAxe(HttpSession session){
        initOrg(session);
        List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxes = attributePolicieAnalyseAxeService.findByOrganization(organization);
        return ResponseEntity.status(HttpStatus.OK).body(attributePolicieAnalyseAxes);
    }

    @PostMapping("/AttributePolicieAnalyseAxe")
    public ResponseEntity<ResponseMessage> postAttributePolicieAnalyseAxe(@RequestBody List<AttributePolicieAnalyseAxe> attributePolicieAnalyseAxes, HttpSession session){
        initOrg(session);

        String message ="";
        try {

            attributePolicieAnalyseAxeService.deleteAll(
                    attributePolicieAnalyseAxeService.findByOrganization(organization)
            );
        }catch (Exception e){

        }

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
    @GetMapping("/calculation_of_the_overall_score")
    public ResponseEntity<CalculationScore> getCalculationScore(HttpSession session){
        initOrg(session);
        CalculationScore calculationScore = attributePolicieAnalyseAxeService.calculTheOverallScore(organization);
        return ResponseEntity.status(HttpStatus.OK).body(calculationScore);
    }


    //Sub-step 3.1

}


