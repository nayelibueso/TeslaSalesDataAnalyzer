package com.coderscampus;

public class CustomListApplication {
	public static void main(String[] args) {
		TeslaSalesAnalyzer.generateReports("Model X", "modelX.csv");
		TeslaSalesAnalyzer.generateReports("Model 3", "model3.csv");
		TeslaSalesAnalyzer.generateReports("Model S", "models.csv");
	}
}
