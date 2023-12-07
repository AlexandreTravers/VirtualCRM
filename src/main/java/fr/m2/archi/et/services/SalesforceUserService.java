package fr.m2.archi.et.services;

import java.util.ArrayList;
import java.util.List;

import fr.m2.archi.et.converter.Converter;
import fr.m2.archi.et.dto.SalesforceUserLeadDto;
import fr.m2.archi.et.dto.UserLeadDto;
import fr.m2.archi.et.services.finds.SalesforceUserFinds;
import fr.m2.archi.et.services.modify.SalesforceUserModify;

public class SalesforceUserService implements UserService {
	private static SalesforceUserService instance;
	private SalesforceUserModify salesforceUserModify;
	private SalesforceUserFinds salesforceUserFinds;
	
	private SalesforceUserService() {
		salesforceUserModify = SalesforceUserModify.getInstance();
		salesforceUserFinds = SalesforceUserFinds.getInstance();
	}
	
	public static SalesforceUserService getInstance() {
		if(instance == null) {
			instance = new SalesforceUserService();
		}
		return instance;
	}
	
	@Override
	public List<UserLeadDto> getUsers() {
		List<UserLeadDto> listUser = new ArrayList<UserLeadDto>();
		for(SalesforceUserLeadDto user: salesforceUserFinds.getUsers()) {
			listUser.add(new UserLeadDto(Converter.convert(user.getInformations())));
		}
		return listUser;
	}

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		List<UserLeadDto> listUser = new ArrayList<UserLeadDto>();
		for(SalesforceUserLeadDto user: salesforceUserFinds.findLeads(lowAnnualRevenue, highAnnualRevenue, state)) {
			listUser.add(new UserLeadDto(Converter.convert(user.getInformations())));
		}
		return listUser;
	}

	@Override
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		List<UserLeadDto> listUser = new ArrayList<UserLeadDto>();
		for(SalesforceUserLeadDto user: salesforceUserFinds.findLeadsByDate(startDate, enDate)) {
			listUser.add(new UserLeadDto(Converter.convert(user.getInformations())));
		}
		return listUser;
	}

	@Override
	public void deleteLead(UserLeadDto user) {
		salesforceUserModify.deleteUser(user.getInformations().getPhone());
	}

	@Override
	public void addLead(UserLeadDto user) {
		salesforceUserModify.addUser(user.getInformations().getPhone());
	}
}
