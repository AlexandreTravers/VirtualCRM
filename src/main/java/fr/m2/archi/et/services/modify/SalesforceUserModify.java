package fr.m2.archi.et.services.modify;


public class SalesforceUserModify {
	private static SalesforceUserModify instance;
	
	private SalesforceUserModify() {}
	
	public static SalesforceUserModify getInstance() {
		if(instance == null) {
			instance = new SalesforceUserModify();
		}
		return instance;
	}
	
	public void addUser(String phoneNumber) {
		//TODO
	}
	
	public void deleteUser(String phoneNumber) {
		//TODO
	}
	
	
}
