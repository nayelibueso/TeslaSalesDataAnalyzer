package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileService {
	public static List<SalesRecord> readSalesData(String fileName) {
		List<SalesRecord> salesRecords = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MMM", Locale.US);

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			br.readLine(); // Skip header line
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ", 2);
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
