package fr.m2.archi.et.client;

import java.util.ArrayList;
import java.util.List;

import fr.m2.archi.et.model.UserLeadDto;
import fr.m2.archi.et.services.SalesforceUserService;

public class CRMSalesforceClient implements CRMClient {

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		// TODO
		return null;
	}

	@Override
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLead(UserLeadDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLead(UserLeadDto user) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<UserLeadDto> getUsers() {
		return SalesforceUserService.getInstance().getUsersInformations();
	}

}
