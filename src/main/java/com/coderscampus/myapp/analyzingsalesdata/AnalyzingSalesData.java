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
		Sales[] modelX = fileService.readingModelXData(); 
		Sales[] modelS = fileService.readingModelSData();
		
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("--------------------");  
		salesService.setModel3YearsSum2017(model3);
		Integer yearlySumModel32017 = salesService.getModel3YearsSum2017();
		System.out.println("2017-> " + yearlySumModel32017);
		System.out.println(); 
		
		Sales[] finalCleanedmodel3S = salesService.sortModel3Array(model3); 
		
		System.out.println(); 
		System.out.println();
		
		Sales[] finalCleanedmodelXS = salesService.sortModelXArray(modelX); 
		Sales[] finalCleanedmodelSS = salesService.sortModelSArray(modelS);
//		salesService.setModel3YearsSum2017(model3);
//		Integer yearlySumModel32017 = salesService.getModel3YearsSum2017();
		
		
		fileService.writesModel3DataToCsv(finalCleanedmodel3S); 
		fileService.writesModelXDataToCsv(finalCleanedmodelXS); 
		fileService.writesModelSDataToCsv(finalCleanedmodelSS);

	}
}
