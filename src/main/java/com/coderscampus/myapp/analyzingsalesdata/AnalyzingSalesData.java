package com.coderscampus.myapp.analyzingsalesdata;

import com.coderscampus.myapp.service.SalesService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
		
		
		Sales[] model3 = fileService.readingModel3Data(); 
		ArrayList<Sales> model3F = new ArrayList<>(Arrays.asList(model3));
		Sales[] modelX = fileService.readingModelXData(); 
		Sales[] modelS = fileService.readingModelSData();
		
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("--------------------");  
		salesService.setModel3YearsSum2017(model3);
		salesService.setModel3YearsSum2018(model3);
		salesService.setModel3YearsSum2019(model3);
		
		Integer yearlySumModel32017 = salesService.getModel3YearsSum2017();
		Integer yearlySumModel32018 = salesService.getModel3YearsSum2018();
		Integer yearlySumModel32019 = salesService.getModel3YearsSum2019();
		
		Map<YearMonth, List<Sales>> groupByPriceMap = 
				model3F.stream().collect(Collectors.groupingBy(model3F::getDate));
		
//		System.out.println("2017-> " + yearlySumModel32017);
//		System.out.println("2018-> " + yearlySumModel32018);
//		System.out.println("2019-> " + yearlySumModel32019);
		System.out.println(); 
		
		salesService.sortModel3Array(model3); 
		
		System.out.println(); 
		System.out.println();
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("--------------------");  
		salesService.setModelSYearsSum2016(modelS);
		salesService.setModelSYearsSum2017(modelS);
		salesService.setModelSYearsSum2018(modelS);
		salesService.setModelSYearsSum2019(modelS);
		
		Integer yearlySumModelS2016 = salesService.getModelSYearsSum2016();
		Integer yearlySumModelS2017 = salesService.getModelSYearsSum2017();
		Integer yearlySumModelS2018 = salesService.getModelSYearsSum2018();
		Integer yearlySumModelS2019 = salesService.getModelSYearsSum2019();
		System.out.println("2016-> " + yearlySumModelS2016);
		System.out.println("2017-> " + yearlySumModelS2017);
		System.out.println("2018-> " + yearlySumModelS2018);
		System.out.println("2019-> " + yearlySumModelS2019);
		System.out.println();
		
		salesService.sortModelSArray(modelS); 
		
		System.out.println(); 
		System.out.println();
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("--------------------");  
		salesService.setModelXYearsSum2016(modelX);
		salesService.setModelXYearsSum2017(modelX);
		salesService.setModelXYearsSum2018(modelX);
		salesService.setModelXYearsSum2019(modelX);
		
		Integer yearlySumModelX2016 = salesService.getModelXYearsSum2016();
		Integer yearlySumModelX2017 = salesService.getModelXYearsSum2017();
		Integer yearlySumModelX2018 = salesService.getModelXYearsSum2018();
		Integer yearlySumModelX2019 = salesService.getModelXYearsSum2019();
		System.out.println("2016-> " + yearlySumModelX2016);
		System.out.println("2017-> " + yearlySumModelX2017);
		System.out.println("2018-> " + yearlySumModelX2018);
		System.out.println("2019-> " + yearlySumModelX2019);
		System.out.println();
		
		salesService.sortModelXArray(modelX);
		
		
//		fileService.writesModel3DataToCsv(finalCleanedmodel3S); 
//		fileService.writesModelXDataToCsv(finalCleanedmodelXS); 
//		fileService.writesModelSDataToCsv(finalCleanedmodelSS);

	}
}
