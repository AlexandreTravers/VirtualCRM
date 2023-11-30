package fr.m2.archi.et.client;

import java.util.ArrayList;
import java.util.List;

import fr.m2.archi.et.model.UserLeadDto;
import fr.m2.archi.et.services.SalesforceUserService;

public class CRMSalesforceClient implements CRMClient {

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		return SalesforceUserService.getInstance().findLeads(lowAnnualRevenue, highAnnualRevenue, state);
	}

	@Override
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		return SalesforceUserService.getInstance().findLeadsByDate(startDate, enDate);
	}

	@Override
	public void deleteLead(UserLeadDto user) {
		SalesforceUserService.getInstance().deleteLead(user);
	}

	@Override
	public void addLead(UserLeadDto user) {
		SalesforceUserService.getInstance().addLead(user);
		
	}
	
	@Override
	public List<UserLeadDto> getUsers() {
		return SalesforceUserService.getInstance().getUsers();
	}

}
