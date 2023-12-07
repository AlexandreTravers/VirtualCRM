package fr.m2.archi.et.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.m2.archi.et.client.CRMClient;
import fr.m2.archi.et.client.CRMInternalClient;
import fr.m2.archi.et.dto.UserLeadDto;
import fr.m2.archi.et.model.JSONModel.JsonRequestForLeads;
import fr.m2.archi.et.model.JSONModel.JsonRequestForLeadsWithDate;

//TODO
//A supprimer pour la version finale

@RestController
@RequestMapping("/api/internal")
public class InternalCRMController {

	private CRMClient crmClient = new CRMInternalClient();

    @GetMapping("/getLeads")
    public List<UserLeadDto> getLeads(
            @RequestParam double lowAnnualRevenue,
            @RequestParam double highAnnualRevenue,
            @RequestParam String state) {
        return crmClient.findLeads(lowAnnualRevenue, highAnnualRevenue, state);
    }
    
    @PostMapping("/getLeads")
    public List<UserLeadDto> getLeads(
    		@RequestBody JsonRequestForLeads request) {
    	List<UserLeadDto> leads = crmClient.findLeads(request.getLowAnnualRevenue(), request.getHighAnnualRevenue(), request.getState());
    	System.out.println("Objets trouvés : ");
    	for(UserLeadDto lead : leads) {
    		System.out.println(lead.toString());
    	}
    	return leads;
    }
    
    @PostMapping("/getLeadsWithDate")
    public List<UserLeadDto> getLeadsWithDate(
    		@RequestBody JsonRequestForLeadsWithDate request) {
    	return crmClient.findLeadsByDate(request.getStartDate(), request.getEndDate());
    }
}
