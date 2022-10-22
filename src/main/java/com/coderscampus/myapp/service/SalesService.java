package com.coderscampus.myapp.service;

import com.coderscampus.myapp.analyzingsalesdata.Sales;
import com.coderscampus.myapp.analyzingsalesdata.Year;

public class SalesService {

	public static Sales createSalesData(String salesMonth, Year salesYear, Integer numMonthlySales) { 
		
		Sales monthlysale = new Sales(salesMonth, salesYear, numMonthlySales);  
		monthlysale.setnumMonthlySales(numMonthlySales);
		monthlysale.setSalesMonth(salesMonth);
		monthlysale.setSalesYear(salesYear); 
		return monthlysale;
		
	}
	
	
}
