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
			br.readLine(); // Skips header
			while ((line = br.readLine()) != null) {
				String[] values = line.split(", ");
				YearMonth date = YearMonth.parse(values[0].trim(), formatter);
				Integer sales = Integer.parseInt(values[1].trim());
				salesRecords.add(new SalesRecord(date, sales));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return salesRecords;
	}
}

	



