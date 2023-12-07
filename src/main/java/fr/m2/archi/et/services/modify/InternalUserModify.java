package fr.m2.archi.et.services.modify;

public class InternalUserModify {
	private static InternalUserModify instance;
	
	private InternalUserModify() {}
	
	public static InternalUserModify getInstance() {
		if(instance == null) {
			instance = new InternalUserModify();
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
