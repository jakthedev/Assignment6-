package com.coderscampus.myapp.service;

import java.time.YearMonth;

import com.coderscampus.myapp.analyzingsalesdata.Sales;
import com.coderscampus.myapp.analyzingsalesdata.Year;

public class SalesService {

	public static Sales createSalesData(YearMonth date, Integer numMonthlySales) { 
		
		Sales saleInfo = new Sales(date, numMonthlySales);  
		saleInfo.setDate(date);
		saleInfo.setNumMonthlySales(numMonthlySales);
		
		
		return saleInfo;
		
	}
	
	
}
