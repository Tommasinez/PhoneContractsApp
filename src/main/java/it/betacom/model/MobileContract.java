package it.betacom.model;

import java.time.LocalDateTime;

public class MobileContract extends PhoneContract{
	private final Double SET_UP_FEE = 1.50;
	
	public MobileContract(String fullName, String phoneNumber) {
		super(fullName, phoneNumber);
	}

	public void updateCallRecord(Integer seconds, LocalDateTime timestamp) {
		PhoneCall call = new PhoneCall();
		call.setDuration(seconds);
		call.setCharge((seconds * getCOST_PER_SECOND()) + getSET_UP_FEE());
		call.setTimestamp(timestamp);
		getOutgoingCallHistory().add(call);
		setBilling(getBilling() + call.getCharge());
	}
	
	public Double getSET_UP_FEE() {
		return SET_UP_FEE;
	}
}
