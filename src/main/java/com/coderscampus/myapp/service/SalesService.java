package com.coderscampus.myapp.service; 


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.coderscampus.myapp.analyzingsalesdata.Sales;
import com.coderscampus.myapp.service.FileService;
import com.coderscampus.myapp.analyzingsalesdata.Year;

public class SalesService {
	
	Sales[] finalCleanedmodel3S;
	
	BufferedReader salesReader = null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
	
	FileService fileservice = new FileService();
	
	Sales[] model3A = fileservice.getModel3();
	
	int i = 0;
	int j = 0;
	int d = 0;

	public static Sales createSalesData(YearMonth date, Integer numMonthlySales) { 
		Sales saleInfo = new Sales();  
		saleInfo.setDate(date);
		saleInfo.setNumMonthlySales(numMonthlySales);
		return saleInfo;
	}
	
	public Sales[] sortModel3Array() {
		
	List<Sales> model3S = Arrays.stream(model3A).collect(Collectors.toList());
	model3S.sort((o2, o1) -> o1.getNumMonthlySales().compareTo(o2.getNumMonthlySales()));

	Sales bmM3 = model3S.get(0);
	System.out.println("The best month for Model 3 was " + bmM3.toStringMS());
	Sales wmM3 = model3S.get(model3S.size() - 1);
	System.out.println("The worst month for Model 3 was " + wmM3.toStringMS());

	Sales[] finalCleanedmodel3S = model3S.toArray(new Sales[0]); 
	
	return finalCleanedmodel3S;
	}
	
	public Sales[] getFinalCleanedModel3() {
	return finalCleanedmodel3S;
	}
	
	
	
}	
