package fr.m2.archi.et.client;

import java.util.List;

import fr.m2.archi.et.dto.VirtualLeadDto;
import fr.m2.archi.et.services.VirtualCRMService;

public class VirtualCRMClient{

	public List<VirtualLeadDto> getUsers() {
		return VirtualCRMService.getInstance().getUsers();
	}

	public List<VirtualLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		return VirtualCRMService.getInstance().findLeads(lowAnnualRevenue, highAnnualRevenue, state);
	}

	public List<VirtualLeadDto> findLeadsByDate(String startDate, String enDate) {
		return VirtualCRMService.getInstance().findLeadsByDate(startDate, enDate);
	}

	public void deleteLead(VirtualLeadDto user) {
		VirtualCRMService.getInstance().deleteLead(user);
		
	}

	public void addLead(VirtualLeadDto user) {
		VirtualCRMService.getInstance().addLead(user);
	}

}
