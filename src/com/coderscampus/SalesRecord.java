package com.coderscampus;

public class SalesRecord {
	//This class will have fields like 'year'. 'month', and 'sa'es'. You will use instances of this class to store data parsed from the CSV file
	private Integer year;
	private Integer month;
	private Integer sales;
	
	//Constructor 
	public SalesRecord(Integer year, Integer month, Integer sales) {
		this.year = year;
		this.month = month;
		this.sales = sales;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	

}
