package com.coderscampus;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomListApplication {
	public static void main(String[] args) {
		List<SalesRecord> model3Sales = TeslaSalesAnalyzer.readSalesData("model3.csv");
		List<SalesRecord> modelSSales = TeslaSalesAnalyzer.readSalesData("modelS.csv");
		List<SalesRecord> modelXSales = TeslaSalesAnalyzer.readSalesData("modelX.csv");

		generateReports(modelXSales, "Model X");
		generateReports(modelSSales, "Model S");
		generateReports(model3Sales, "Model 3");
	}

	public static void generateReports(List<SalesRecord> salesRecords, String modelName) {
		Map<Integer, Integer> yearlySalesMap = salesRecords.stream().collect(Collectors
				.groupingBy(record -> record.getDate().getYear(), Collectors.summingInt(SalesRecord::getSales)));

		SalesRecord bestMonth = salesRecords.stream().max(Comparator.comparingInt(SalesRecord::getSales)).orElse(null);
		SalesRecord worstMonth = salesRecords.stream().min(Comparator.comparingInt(SalesRecord::getSales)).orElse(null);
		
		System.out.println(modelName + " Yearly Sales Report");
		yearlySalesMap.forEach((year, sales) -> System.out.println(year + " -> " + sales));
		if (bestMonth != null) {
			System.out.println("The best month for " + modelName + " was: " + bestMonth.getDate());
		}
		if (worstMonth != null) {
			System.out.println("The worst month for " + modelName + " was: " + worstMonth.getDate());
		}
	}

}
