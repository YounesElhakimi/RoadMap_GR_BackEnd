package ma.ehtp.gestionrisqueit.phase0.conrollers;


import ma.ehtp.gestionrisqueit.phase0.modelles.Organization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ContrTest extends InitOrg{

    @GetMapping("/testORG")
    public Organization getOrg(HttpSession session){
        initOrg(session);

        return organization;
    }
}
