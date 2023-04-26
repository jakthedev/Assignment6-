package com.coderscampus.myapp.analyzingsalesdata;

import com.coderscampus.myapp.service.SalesService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import com.coderscampus.myapp.service.FileService;
import com.coderscampus.myapp.service.SalesService;

public class AnalyzingSalesData {

	public static void main(String[] args) throws IOException {
		
		SalesService salesService = new SalesService(); 
		FileService fileService = new FileService();
		
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("--------------------");
		Sales[] model3 = fileService.readingModel3Data(); 
		ArrayList<Sales> model3F = new ArrayList<>(Arrays.asList(model3));
		
		Map<Object, List<Sales>> groupByYearMap = model3F.stream().collect(Collectors
				.groupingBy((year) -> year.getDate().getYear())); 
		
		for (java.util.Map.Entry<Object, List<Sales>> entry : groupByYearMap.entrySet()) {
	        System.out.println(entry.getKey() + " -> " + entry.getValue().stream()
	            .mapToInt(sale -> sale.getNumMonthlySales())
	            .sum());
	    }
		
		System.out.println();
		
		salesService.sortModel3Array(model3); 
		
		System.out.println();
		System.out.println();
	
		System.out.println("Model S Yearly Sales Report");
		System.out.println("--------------------");  
		Sales[] modelS = fileService.readingModelSData(); 
		ArrayList<Sales> modelSF = new ArrayList<>(Arrays.asList(modelS));
		
		Map<Object, List<Sales>> groupByYearMap1 = modelSF.stream().collect(Collectors
				.groupingBy((year) -> year.getDate().getYear())); 
		
		for (java.util.Map.Entry<Object, List<Sales>> entry : groupByYearMap1.entrySet()) {
	        System.out.println(entry.getKey() + " -> " + entry.getValue().stream()
	            .mapToInt(sale -> sale.getNumMonthlySales())
	            .sum());
	    }
		
		System.out.println();
		
		salesService.sortModelSArray(modelS); 
		
		System.out.println();
		System.out.println();
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("--------------------");  
		Sales[] modelX = fileService.readingModelXData(); 
		ArrayList<Sales> modelXF = new ArrayList<>(Arrays.asList(modelX));
		
		Map<Object, List<Sales>> groupByYearMap2 = modelXF.stream().collect(Collectors
				.groupingBy((year) -> year.getDate().getYear())); 
		
		for (java.util.Map.Entry<Object, List<Sales>> entry : groupByYearMap2.entrySet()) {
	        System.out.println(entry.getKey() + " -> " + entry.getValue().stream()
	            .mapToInt(sale -> sale.getNumMonthlySales())
	            .sum());
	    }
		
		System.out.println();
		
		salesService.sortModelXArray(modelX);
		
		

		
		
//		fileService.writesModel3DataToCsv(finalCleanedmodel3S); 
//		fileService.writesModelXDataToCsv(finalCleanedmodelXS); 
//		fileService.writesModelSDataToCsv(finalCleanedmodelSS);

	}
}
