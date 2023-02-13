package it.betacom.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.betacom.model.LandlineContract;
import it.betacom.model.PhoneContract;

public class WritePDF {
	public static void getBill(PhoneContract contract) {
		try {
			Document document = new Document();
			DecimalFormat decimal = new DecimalFormat("#0.00");
			PdfWriter.getInstance(document, new FileOutputStream(contract.getPhoneNumber() + ".pdf"));
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add("\nFull Name: " + contract.getFullName());
			paragraph.add("\nPhone Number: " + contract.getPhoneNumber());

			if (contract instanceof LandlineContract) {
				paragraph.add("\nHome Address: " + ((LandlineContract) contract).getAddress());
			}

			paragraph.add("\nOverall Outgoing Calls: " + String.valueOf(contract.getOutgoingCallHistory().size()));
			paragraph.add("\nYour billing: €" + decimal.format(contract.getBilling()));
			document.add(paragraph);
			document.close();
		} catch (FileNotFoundException | DocumentException exception) {
			exception.printStackTrace();
		}
	}
}
