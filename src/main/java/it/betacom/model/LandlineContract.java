package it.betacom.model;

public class LandlineContract extends PhoneContract{
	private String address;
	
	public LandlineContract(String fullName, String phoneNumber, String address) {
		super(fullName, phoneNumber);
		this.address = address;
	}
	
	void getUserDetails() {
		super.getUserDetails();
		System.out.println(getAddress());
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
