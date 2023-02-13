package it.betacom.controller;

import java.time.LocalDateTime;
import java.util.Random;

import it.betacom.model.LandlineContract;
import it.betacom.model.MobileContract;
import it.betacom.model.PhoneContract;
import it.betacom.util.WriteCSV;
import it.betacom.util.WritePDF;

public class Controller {		
	public static void main(String[] args) {
		PhoneContract landline = new LandlineContract("Luigi Verdi", "0869754231", "Via Garibaldi, 42");
		PhoneContract mobile = new MobileContract("Mario Rossi", "3450126789");
		
		Integer i = 0;
		while (i < 8) {
			Random random = new Random();
			Integer duration = random.nextInt(1000);
			LocalDateTime timestamp = LocalDateTime.now();
			mobile.updateCallRecord(duration, timestamp);
			landline.updateCallRecord(duration, timestamp);
			i++;
		}

		WritePDF.getBill(landline);
		WritePDF.getBill(mobile);
		WriteCSV.getHistoryTable(landline);
		WriteCSV.getHistoryTable(mobile);
	}
}
