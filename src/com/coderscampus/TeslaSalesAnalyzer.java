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
		List<SalesRecord> salesRecords = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MMM", Locale.US); //ensures that the month abreviations are intrepreted according to US English.

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                // Split the line into year-month and sales parts
            	String[] parts = line.split(" ", 2);
                if (parts.length != 2) {
                    System.err.println("Skipping line with incorrect format: " + line);
                    continue;
                }
                String dateStr = parts[0];
                String salesStr = parts[1].trim();

                try {
                    YearMonth date = YearMonth.parse(dateStr, formatter);
                    Integer sales = Integer.parseInt(salesStr);
                    salesRecords.add(new SalesRecord(date, sales));
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

	



