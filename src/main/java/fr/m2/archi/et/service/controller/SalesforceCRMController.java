package fr.m2.archi.et.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2.archi.et.client.CRMSalesforceClient;
import fr.m2.archi.et.model.UserLeadDto;
import fr.m2.archi.et.model.JSONModel.JsonRequestForLeads;
import fr.m2.archi.et.model.JSONModel.JsonRequestForLeadsWithDate;
import fr.m2.archi.et.client.CRMClient;

@RestController
@RequestMapping("/api/salesforce")
public class SalesforceCRMController {

	CRMClient crmClient = new CRMSalesforceClient();
	
	@PostMapping("/getLeads")
    public List<UserLeadDto> getLeads(
    		@RequestBody JsonRequestForLeads request) {
    	return crmClient.findLeads(request.getLowAnnualRevenue(), request.getHighAnnualRevenue(), request.getState());
    }
	
	@PostMapping("/getLeadsByDate")
	public List<UserLeadDto> getLeadsByDate(
			@RequestBody JsonRequestForLeadsWithDate request) {
		return crmClient.findLeadsByDate(request.getStartDate(), request.getEndDate());
	}
	
	@GetMapping("/allUsers")
    public List<UserLeadDto> getUsers() {
    	return crmClient.getUsers();
    }
}
