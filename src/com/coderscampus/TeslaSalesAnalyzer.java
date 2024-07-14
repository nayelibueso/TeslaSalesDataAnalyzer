package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TeslaSalesAnalyzer {
	// This could be a utility or service class responsible for handling the logic
	// of reading CSV files, parsing them into
	// SalesRecord objects, and performing calculations (like yearly sales totals,
	// best/worst months) using Java Streams.
	public static List<SalesRecord> readSalesData(String fileName) {
		List<SalesRecord> salesRecords = new ArrayList<>(); // create an empty list to store sale records
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MMM", Locale.US); // ensures that the month
																						// abreviations are intrepreted
																						// according to US English.

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			br.readLine(); // Skip header line
			while ((line = br.readLine()) != null) {
				// Split the line into year-month and sales parts
				String[] parts = line.split(" ", 2); // S[lits current line into two parts based on the first space
														// encountered
				String dateStr = parts[0]; // Extracts first part of string
				String salesStr = parts[1].trim(); // extracts the second part and trims any extra space

				try {
					YearMonth date = YearMonth.parse(dateStr, formatter); // Parses to YearMonth object and uses
																			// predefined formatter
					Integer sales = Integer.parseInt(salesStr); // Parses into an Integer
					salesRecords.add(new SalesRecord(date, sales)); // Adds to list
				} catch (Exception e) {
					System.err.println("Error parsing line: " + line);
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return salesRecords;
	}
}
