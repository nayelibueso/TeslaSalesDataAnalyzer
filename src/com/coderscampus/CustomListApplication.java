package com.coderscampus;

import java.util.List;

public class CustomListApplication {
	//This class will orchestrate reading data from CSV filr, processing it using Java Streams, and outputting the reports

	public static void main(String[] args) {
		List<SalesRecord> model3Sales = TeslaSalesAnalyzer.readSalesData("model3.csv");
		List<SalesRecord> modelSSales = TeslaSalesAnalyzer.readSalesData("modelS.csv");
		List<SalesRecord> modelXSales = TeslaSalesAnalyzer.readSalesData("modelX.csv");
		
		System.out.println("Model3 sales -> " + model3Sales);

	}

}
