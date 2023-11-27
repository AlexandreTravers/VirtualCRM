package fr.m2.archi.et.client;

import java.util.List;

import fr.m2.archi.et.model.UserLeadDto;
import fr.m2.archi.et.services.InternalUserService;

public class CRMInternalClient implements CRMClient {

	@Override
	public List<UserLeadDto> getUsers() {
		return InternalUserService.getInstance().getUsers();
	}

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		return InternalUserService.getInstance().findLeads(lowAnnualRevenue, highAnnualRevenue, state);
	}

	@Override
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		return InternalUserService.getInstance().findLeadsByDate(startDate, enDate);
	}

	@Override
	public void deleteLead(UserLeadDto user) {
		InternalUserService.getInstance().deleteLead(user);
	}

	@Override
	public void addLead(UserLeadDto user) {
		InternalUserService.getInstance().addLead(user);
		
	}

}
