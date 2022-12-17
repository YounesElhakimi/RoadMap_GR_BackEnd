package ma.ehtp.gestionrisqueit.phase1.conrollers;


import ma.ehtp.gestionrisqueit.phase0.conrollers.InitOrg;
import ma.ehtp.gestionrisqueit.phase0.messages.ResponseMessage;
import ma.ehtp.gestionrisqueit.phase0.modelles.Phase;
import ma.ehtp.gestionrisqueit.phase0.tools.U;
import ma.ehtp.gestionrisqueit.phase1.modelles.*;
import ma.ehtp.gestionrisqueit.phase1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class Phase1Step1 extends InitOrg {

    @Autowired
    PrincipleService principleService;
    @Autowired
    PolicieService policieService;
    @Autowired
    AnalyseAxeService analyseAxeService;
    @Autowired
    MaturityService maturityService;
    @Autowired
    StakeholderService stakeholderService;



    //Sub-step 1.1
    @GetMapping("/{phase}/principles")
    public ResponseEntity<List<Principle>> getPrinciples(HttpSession session , @PathVariable String phase){
        initOrg(session);
        List<Principle> principleList = principleService.findByOrganizationAndPhase(organization ,Phase.valueOf(phase.toUpperCase()));
        return ResponseEntity.status(HttpStatus.OK).body(principleList);
    }

    @PostMapping("/{phase}/principles")
    public ResponseEntity<ResponseMessage> postPrinciples(@RequestBody List<Principle> principleList, HttpSession session, @PathVariable String phase){
     initOrg(session);
       String message ="";
     //  List<Principle> oldPrinciples =   principleService.findByOrganizationAndPhase(organization ,Phase.valueOf(phase.toUpperCase()));

        try {

            principleList.forEach(principle -> {
                principle.setOrganization(organization);
                principle.setPhase(Phase.valueOf(phase.toUpperCase()));

            });

            message = "save successfully: ";
         //   principleService.deleteAll(oldPrinciples);
            principleService.saveAll(principleList);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            System.out.println("e : "+e);
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }



    //Sub-step 1.2
    @GetMapping("/{phase}/policies")
    public ResponseEntity<List<Policie>> getPolicies(HttpSession session,@PathVariable String phase){
        initOrg(session);
        List<Policie> policieList = policieService.findByOrganizationAndPhase(organization,Phase.valueOf(phase.toUpperCase()));
        return ResponseEntity.status(HttpStatus.OK).body(policieList);

    }

    @PostMapping("/{phase}/policies")
    public ResponseEntity<ResponseMessage> postPolicies(@RequestBody List<Policie> policieList,@PathVariable String phase, HttpSession session){
        initOrg(session);

        String message ="";
       // List<Policie> oldPolicies = policieService.findByOrganizationAndPhase(organization,Phase.valueOf(phase.toUpperCase()));

        try {

            policieList.forEach( policie ->{
                policie.setOrganization(organization);
                policie.setPhase(Phase.valueOf(phase.toUpperCase()));
              //  policieService.save(policie);
                System.out.println(policie);
            });

            policieService.saveAll(policieList);
            message = "save successfully: ";
         //   policieService.deleteAll(oldPolicies);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    //Sub-step 1.3
    @GetMapping("/{phase}/analysesaxes")
    public ResponseEntity<List<AnalyseAxe>> getAnalyseAxes(@PathVariable String phase,HttpSession session){
        initOrg(session);
        List<AnalyseAxe> analyseAxeList = analyseAxeService.findByOrganizationAndPhase(organization,Phase.valueOf(phase.toUpperCase()));
        return ResponseEntity.status(HttpStatus.OK).body(analyseAxeList);
    }

    @GetMapping("/{phase}/analysesaxes/notChecked")
    public ResponseEntity<List<AnalyseAxe>> getAnalyseAxesNotSel(@PathVariable String phase,HttpSession session){
        initOrg(session);
        List<AnalyseAxe> analyseAxeList = analyseAxeService.findByOrganizationAndPhaseAndIsChecked(organization,Phase.valueOf(phase.toUpperCase()),false);
        return ResponseEntity.status(HttpStatus.OK).body(analyseAxeList);
    }

    @PostMapping("/{phase}/analysesaxes")
    public ResponseEntity<ResponseMessage> postAnalyseAxes(@PathVariable String phase,@RequestBody List<AnalyseAxe> analyseAxeList, HttpSession session){
        initOrg(session);

        String message ="";

       // List<AnalyseAxe> oldAnalyseAxes =   analyseAxeService.findByOrganizationAndPhase(organization , Phase.valueOf(phase.toUpperCase()));


        try {

            analyseAxeList.forEach(analyseAxe -> {
                analyseAxe.setOrganization(organization);
                analyseAxe.setPhase(Phase.valueOf(phase.toUpperCase()));
                System.out.println(analyseAxe);
            });

            analyseAxeService.saveAll(analyseAxeList);
            message = "save successfully: ";

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }


    //Sub-step 1.4
    @GetMapping("/{phase}/maturity")
    public ResponseEntity<List<Maturity>> getMaturity(HttpSession session , @PathVariable String phase){
        initOrg(session);
        List<Maturity> maturityList = maturityService.findByOrganization(organization);
        System.out.println("maturityList.size() " +maturityList.size());
        if (maturityList.size() == 0){
            maturityList = new ArrayList<>();
            maturityList.add(new Maturity(null,Phase.valueOf(phase.toUpperCase()),0,0,0,organization));
            maturityList.add(new Maturity(null,Phase.valueOf(phase.toUpperCase()),1,1,72,organization));
            maturityList.add(new Maturity(null,Phase.valueOf(phase.toUpperCase()),2,73,145,organization));
            maturityList.add(new Maturity(null,Phase.valueOf(phase.toUpperCase()),3,146,212,organization));
            maturityList.add(new Maturity(null,Phase.valueOf(phase.toUpperCase()),4,213,283,organization));
            maturityList.add(new Maturity(null,Phase.valueOf(phase.toUpperCase()),5,284,356,organization));
            maturityList = maturityService.saveAll(maturityList);
        }
        return ResponseEntity.status(HttpStatus.OK).body(maturityList);

    }

    @PostMapping("/{phase}/maturity")
    public ResponseEntity<ResponseMessage> postMaturity(@RequestBody List<Maturity> maturityList, HttpSession session,@PathVariable String phase){
        initOrg(session);

        String message ="";

        try {

            maturityList.forEach(maturity -> {
                maturity.setOrganization(organization);
                maturity.setPhase(Phase.valueOf(phase.toUpperCase()));
                System.out.println(maturity);
            });

            maturityService.saveAll(maturityList);
            message = "save successfully: ";

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }



    //Sub-step 1.5
    @GetMapping("/{phase}/stakeholders")
    public ResponseEntity<List<Stakeholder>> getStakeholder(HttpSession session , @PathVariable String phase){
        initOrg(session);
        List<Stakeholder> stakeholderList = stakeholderService.findByOrganizationAndPhase(organization , Phase.valueOf(phase.toUpperCase()));
        return ResponseEntity.status(HttpStatus.OK).body(stakeholderList);
    }

    @PostMapping("/{phase}/stakeholders")
    public ResponseEntity<ResponseMessage> postStakeholder(@RequestBody List<Stakeholder> stakeholderList, HttpSession session,@PathVariable String phase){
        initOrg(session);

        String message ="";
        /*try {

            stakeholderService.deleteAll(
                    stakeholderService.findByOrganization(organization)
            );
        }catch (Exception e){

        }

         */

        try {


            stakeholderList.forEach(stakeholder -> {
                stakeholder.setOrganization(organization);
                stakeholder.setPhase(Phase.valueOf(phase.toUpperCase()));
            });

            stakeholderService.saveAll(stakeholderList);
            message = "save successfully: ";

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }




}
