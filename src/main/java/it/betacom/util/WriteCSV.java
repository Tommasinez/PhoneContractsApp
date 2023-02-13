package it.betacom.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import it.betacom.model.PhoneCall;
import it.betacom.model.PhoneContract;

public class WriteCSV {
	public static void getHistoryTable(PhoneContract contract) {
		try {
			ArrayList<PhoneCall> history = contract.getOutgoingCallHistory();
			CSVWriter writer = new CSVWriter(new FileWriter(contract.getPhoneNumber() + ".csv"));
			DateTimeFormatter dateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
			DecimalFormat decimal = new DecimalFormat("#0.00");

			String[] header = { "#", "Timestamp", "Duration", "Charge" };
			writer.writeNext(header);

			Integer i = 0;
			while (i < history.size()) {

				Integer duration = history.get(i).getDuration();
				Double charge = history.get(i).getCharge();
				LocalDateTime timestamp = history.get(i).getTimestamp();

				String[] call = { i.toString(), dateTime.format(timestamp), duration.toString(),
						decimal.format(charge) };
				writer.writeNext(call);
				i++;
			}

			String[] total = { "#", "", "Your Total", decimal.format(contract.getBilling()) };
			writer.writeNext(total);

			writer.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
