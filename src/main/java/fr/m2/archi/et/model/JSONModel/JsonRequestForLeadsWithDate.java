package fr.m2.archi.et.model.JSONModel;

public class JsonRequestForLeadsWithDate {
	private String startDate;
	private String endDate;
	
	public JsonRequestForLeadsWithDate(String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
}
