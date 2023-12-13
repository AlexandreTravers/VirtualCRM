package fr.m2.archi.et.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2.archi.et.client.VirtualCRMClient;
import fr.m2.archi.et.dto.VirtualLeadDto;
import fr.m2.archi.et.model.JSONModel.JsonRequestForLeads;
import fr.m2.archi.et.model.JSONModel.JsonRequestForLeadsWithDate;

@RestController
@RequestMapping("/api")
public class VirtualCRMController {
	VirtualCRMClient crmClient = new VirtualCRMClient();
	
	@GetMapping("/allUsers")
    public List<VirtualLeadDto> getUsers() {
    	return crmClient.getUsers();
    }
	
	@PostMapping("/getLeads")
    public List<VirtualLeadDto> getLeads(
    		@RequestBody JsonRequestForLeads request) {
    	return crmClient.findLeads(request.getLowAnnualRevenue(), request.getHighAnnualRevenue(), request.getState());
    }
	
	@PostMapping("/getLeadsByDate")
	public List<VirtualLeadDto> getLeadsByDate(
			@RequestBody JsonRequestForLeadsWithDate request) {
		return crmClient.findLeadsByDate(request.getStartDate(), request.getEndDate());
	}
}