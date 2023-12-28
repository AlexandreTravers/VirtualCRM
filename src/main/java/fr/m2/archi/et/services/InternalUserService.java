package fr.m2.archi.et.services;

import java.util.ArrayList;
import java.util.List;

import fr.m2.archi.et.converter.Converter;
import fr.m2.archi.et.dto.*;
import fr.m2.archi.et.services.finds.InternalUserFinds;
import fr.m2.archi.et.services.modify.InternalUserModify;

public class InternalUserService implements UserService {
	private static InternalUserService internalUserService;
	private InternalUserFinds internalUserFinds;
	private InternalUserModify internalUserModify;
	
	private InternalUserService() {
		this.internalUserFinds = InternalUserFinds.getInstance();
		this.internalUserModify = InternalUserModify.getInstance();
	}
	
	public static InternalUserService getInstance() {
		if(internalUserService == null) {
			internalUserService = new InternalUserService();
		}
		return internalUserService;
	}

	@Override
	public List<UserLeadDto> getUsers() {
		List<UserLeadDto> listUser = new ArrayList<UserLeadDto>();
		for(InternalUserLeadDto user: internalUserFinds.getUsers()) {
			listUser.add(new UserLeadDto(Converter.convert(user.getInformations())));
		}
		return listUser;
	}

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		List<UserLeadDto> listUser = new ArrayList<UserLeadDto>();
		for(InternalUserLeadDto user: internalUserFinds.findLeads(lowAnnualRevenue, highAnnualRevenue, state)) {
			listUser.add(new UserLeadDto(Converter.convert(user.getInformations())));
		}
		return listUser;
	}

	@Override
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		List<UserLeadDto> listUser = new ArrayList<UserLeadDto>();
		for(InternalUserLeadDto user: internalUserFinds.findLeadsByDate(startDate, enDate)) {
			listUser.add(new UserLeadDto(Converter.convert(user.getInformations())));
		}
		return listUser;
	}

	@Override
	public void deleteLead(String phoneNumber) {
		internalUserModify.deleteUser(phoneNumber);
	}

	@Override
	public void addLead(UserLeadDto user) {
		internalUserModify.addUser(user.getInformations().getPhone());
	}

}
