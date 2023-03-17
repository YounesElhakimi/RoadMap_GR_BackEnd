package ma.ehtp.gestionrisqueit.phase0.conrollers;


import ma.ehtp.gestionrisqueit.phase0.messages.ResponseMessage;
import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;

import ma.ehtp.gestionrisqueit.phase0.tools.U;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;



@RestController
public class Phase0 extends InitOrg{



    @GetMapping("")
    public String index(HttpSession session){
        session.setAttribute("organization" , null);
        return "phase0/index";
    }



    @GetMapping("/thisOrg")
    public Organization newOrgpage( HttpSession session){
        initOrg(session);
        Organization organization = (Organization) session.getAttribute("organization");
        System.out.println("this organization : "+organization);
        return organization;
    }

    @PostMapping("/newOrg")
    public ResponseEntity<ResponseMessage> createNewOrg(@RequestBody Organization organization  , HttpSession session){


        String message = "";
        try {
            message = "save successfully: ";


            organization = organizationService.save(organization);



            session.setAttribute("organization" , organization);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to save!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    @GetMapping("/ExOrg")
    public List<Organization> getAllExOrg(){
        List<Organization> organizationList = organizationService.findAll();
        return organizationList;
    }
    @PostMapping("/ExOrg")
    public ResponseEntity<ResponseMessage> selectExOrg(@RequestBody Organization organization  , HttpSession session){


        String message = "";
        try {


            organizationService.findById(organization.getId()).ifPresent(organization1 -> {
                session.setAttribute("organization" , organization1);

            });
            message = "init org successfully: ";
            System.out.println("init org successfully : " + organization);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        }catch (Exception e){
            message = "Fail to init org!";
            U.ptxt("error .............................." + e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }







}
