package fr.m2.archi.et.services;

import java.util.List;

import fr.m2.archi.et.dto.UserLeadDto;

public interface UserService {
	public List<UserLeadDto> getUsers();
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state);
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate);
	public void deleteLead(UserLeadDto user);
	public void addLead(UserLeadDto user);
}
