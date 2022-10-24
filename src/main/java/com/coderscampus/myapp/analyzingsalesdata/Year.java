package com.coderscampus.myapp.analyzingsalesdata;

import com.coderscampus.myapp.analyzingsalesdata.Sales;

public enum Year { 
	DEFAULT(0),
    TWOTHOUSANDSIXTEEN(16), 
    TWOTHOUSANDSEVENTEEN(17), 
    TWOTHOUSANDEIGHTEEN(18),
    TWOTHOUSANDNINETHTEEN(19);
	
	private final int year; 
	
	Year(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
 
}