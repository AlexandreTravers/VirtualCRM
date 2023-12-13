package fr.m2.archi.et.manager;

import java.util.ArrayList;
import java.util.List;

import fr.m2.archi.et.dto.UserLeadDto;
import fr.m2.archi.et.services.InternalUserService;
import fr.m2.archi.et.services.SalesforceUserService;

public class CRMUserManager {
	private InternalUserService internalUserService;
	private SalesforceUserService salesforceUserService;
	
	private static CRMUserManager instance;
	
	public static CRMUserManager getInstance() {
		if(instance == null) {
			instance = new CRMUserManager();
		}
		return instance;
	}
	
	private CRMUserManager() {
		internalUserService = InternalUserService.getInstance();
		salesforceUserService = SalesforceUserService.getInstance();
	}
	
	
	public List<UserLeadDto> getUsers() {
		List<UserLeadDto> userList = new ArrayList<UserLeadDto>();
		userList.addAll(internalUserService.getUsers());
		userList.addAll(salesforceUserService.getUsers());
		return userList;
	}

	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		List<UserLeadDto> userList = new ArrayList<UserLeadDto>();
		userList.addAll(internalUserService.findLeads(lowAnnualRevenue, highAnnualRevenue, state));
		userList.addAll(salesforceUserService.findLeads(lowAnnualRevenue, highAnnualRevenue, state));
		return userList;
	}

	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		List<UserLeadDto> userList = new ArrayList<UserLeadDto>();
		userList.addAll(internalUserService.findLeadsByDate(startDate, enDate));
		userList.addAll(salesforceUserService.findLeadsByDate(startDate, enDate));
		return userList;
	}

	public void deleteLead(UserLeadDto user) {
		internalUserService.deleteLead(user);
		salesforceUserService.deleteLead(user);
	}

	public void addLead(UserLeadDto user) {
		internalUserService.addLead(user);
		salesforceUserService.addLead(user);
	}
}