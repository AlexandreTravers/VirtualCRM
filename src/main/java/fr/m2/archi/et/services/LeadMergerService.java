package fr.m2.archi.et.services;

import java.util.List;

import fr.m2.archi.et.dto.UserLeadDto;

public class LeadMergerService {
	private static LeadMergerService instance;
	private InternalUserService internalUserService;
	
	private LeadMergerService() {
		internalUserService = InternalUserService.getInstance();
	}
	
	public static LeadMergerService getInstance() {
		if(instance == null) {
			instance = new LeadMergerService();
		}
		return instance;
	}
	
	public void merge(List<UserLeadDto> users) {
		List<UserLeadDto> internalUsers = internalUserService.getUsers();
		
		for(UserLeadDto user: users) {
		    boolean userExists = false;
		    
		    for(UserLeadDto internalUser : internalUsers) {
		    	if(internalUser.getInformations().getPhone().equals(user.getInformations().getPhone())) {
		    		userExists = true;
		    		break;
		    	}
		    }

		    if (!userExists) {
		        internalUserService.addLead(user);
		    }
		}
	}
}
