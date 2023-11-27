package fr.m2.archi.et.services;

import java.util.List;

import fr.m2.archi.et.model.UserLeadDto;

public class InternalUserService implements UserService {
	private final static int INTERNAL_SERVER_PORT = 8080;
	private final static String API_URL = "http://localhost:" + INTERNAL_SERVER_PORT + "/api";
	
	private static InternalUserService internalUserService;
	
	private InternalUserService() {}
	
	public static InternalUserService getInstance() {
		if(internalUserService == null) {
			internalUserService = new InternalUserService();
		}
		return internalUserService;
	}

	@Override
	public List<UserLeadDto> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		// TODO Auto-generated method stub
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

}
