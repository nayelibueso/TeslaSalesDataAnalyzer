package com.coderscampus;

import java.time.YearMonth;

public class SalesRecord {
	// This class will have fields like 'year'. 'month', and 'sa'es'. You will use
	// instances of this class to store data parsed from the CSV file
	private YearMonth date;
	private Integer sales;

	public SalesRecord(YearMonth date, Integer sales) {
		this.date = date;
		this.sales = sales;
	}

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "SalesRecord [date=" + date + ", sales=" + sales + "]";
	}

}
