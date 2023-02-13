package it.betacom.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class PhoneContract {
	private String fullName;
	private String phoneNumber;
	private Double billing = 0.0;
	private ArrayList<PhoneCall> outgoingCallHistory = new ArrayList<PhoneCall>();
	private final Double COST_PER_SECOND = 0.01;

	PhoneContract(String fullName, String phoneNumber) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}

	void getUserDetails() {
		System.out.println(getFullName());
		System.out.println(getPhoneNumber());
	}

	public void updateCallRecord(Integer seconds, LocalDateTime timestamp) {
		PhoneCall call = new PhoneCall();
		call.setDuration(seconds);
		call.setCharge(seconds * getCOST_PER_SECOND());
		call.setTimestamp(timestamp);
		getOutgoingCallHistory().add(call);
		setBilling(getBilling() + call.getCharge());
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getBilling() {
		return billing;
	}

	public void setBilling(Double billing) {
		this.billing = billing;
	}

	public ArrayList<PhoneCall> getOutgoingCallHistory() {
		return outgoingCallHistory;
	}

	public void setOutgoingCallHistory(ArrayList<PhoneCall> outgoingCallHistory) {
		this.outgoingCallHistory = outgoingCallHistory;
	}

	public Double getCOST_PER_SECOND() {
		return COST_PER_SECOND;
	}
}
