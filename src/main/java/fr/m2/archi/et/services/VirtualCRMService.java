package fr.m2.archi.et.services;

import java.util.ArrayList;
import java.util.List;

import fr.m2.archi.et.converter.VirtualConverter;
import fr.m2.archi.et.dto.UserLeadDto;
import fr.m2.archi.et.dto.VirtualLeadDto;
import fr.m2.archi.et.manager.CRMUserManager;

public class VirtualCRMService {
	private static VirtualCRMService instance;
	
	private CRMUserManager crmUserManager;
	
	public static VirtualCRMService getInstance() {
		if(instance == null) {
			instance = new VirtualCRMService();
		}
		return instance;
	}
	
	private VirtualCRMService() {
		crmUserManager = CRMUserManager.getInstance();
	}
	
	public List<VirtualLeadDto> getUsers() {
		List<VirtualLeadDto> userList = new ArrayList<VirtualLeadDto>();
		for(UserLeadDto user: crmUserManager.getUsers()) {
			userList.add(VirtualConverter.convert(user));
		}
		return userList;
	}

	public List<VirtualLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		List<VirtualLeadDto> userList = new ArrayList<VirtualLeadDto>();
		for(UserLeadDto user: crmUserManager.findLeads(lowAnnualRevenue, highAnnualRevenue, state)) {
			userList.add(VirtualConverter.convert(user));
		}
		return userList;
	}

	public List<VirtualLeadDto> findLeadsByDate(String startDate, String enDate) {
		List<VirtualLeadDto> userList = new ArrayList<VirtualLeadDto>();
		for(UserLeadDto user: crmUserManager.findLeadsByDate(startDate, enDate)) {
			userList.add(VirtualConverter.convert(user));
		}
		return userList;
	}

	public void deleteLead(String phoneNumber) {
		crmUserManager.deleteLead(phoneNumber);
	}

	public void addLead(VirtualLeadDto user) {
		crmUserManager.addLead(VirtualConverter.convert(user));
	}
	
	public void merge() {
		crmUserManager.merge();
	}
}
