package com.coderscampus.myapp.analyzingsalesdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import com.coderscampus.myapp.service.SalesService;

public class AnalyzingSalesData {

	public static void main(String[] args) throws IOException {

		Sales[] model3 = new Sales[30];
		Sales[] modelS = new Sales[48];
		Sales[] modelX = new Sales[48];

		BufferedReader salesReader = null;
		BufferedReader salesReader1 = null;
		BufferedReader salesReader2 = null;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");

		int i = 0;
		int j = 0;
		int d = 0;

		try {
			salesReader = new BufferedReader(new FileReader("model3.csv"));
			salesReader1 = new BufferedReader(new FileReader("modelS.csv"));
			salesReader2 = new BufferedReader(new FileReader("modelX.csv"));

			salesReader.readLine();
			salesReader1.readLine();
			salesReader2.readLine();

			while (salesReader != null && salesReader1 != null && salesReader2 != null) {
				String model3Info = salesReader.readLine();
				String[] modelstr = model3Info.split(",");

				String modelSInfo = salesReader1.readLine();
				String[] modelstr1 = modelSInfo.split(",");

				String modelXInfo = salesReader2.readLine();
				String[] modelstr2 = modelXInfo.split(",");

				// stream a if() in to where year is to match the constant status(year) it
				// should go to
				Sales sale = SalesService.createSalesData(YearMonth.parse(modelstr[0], formatter),
						Integer.valueOf(modelstr[1]));

				Sales sale2 = SalesService.createSalesData(YearMonth.parse(modelstr1[0], formatter),
						Integer.valueOf(modelstr1[1]));

				Sales sale3 = SalesService.createSalesData(YearMonth.parse(modelstr2[0], formatter),
						Integer.valueOf(modelstr2[1]));

				// System.out.println(sale.toStringM3());
				model3[i++] = sale;
				// System.out.println(i);
				
				List<Sales> model3S =  Arrays.stream(model3).collect(Collectors.toList()); 
				
				List<Integer> model3SA = model3S.stream()
						.map(amount -> amount.getNumMonthlySales())
						.collect(Collectors.toList());
				
				for (Integer saleA : model3SA) {
					System.out.println(saleA); 
					System.out.println("hey");
				}

				//System.out.println(sale2.toStringMS());
				modelS[j++] = sale2;
				// System.out.println(j);

				 //System.out.println(sale3.toStringMX());
				modelX[d++] = sale3;
				// System.out.println(d);
				
				
				//List<Integer> model3S = new ArrayList<Integer>(); 
//				List<Sales> model3S =  Arrays.stream(model3).collect(Collectors.toList()); 
//				
//				List<Integer> model3SA = model3S.stream()
//						.map(amount -> amount.getNumMonthlySales())
//						.collect(Collectors.toList());
//				
//				for (Integer saleA : model3SA) {
//					System.out.println(saleA); 
//					System.out.println("hey");
//				}
				
				
			}
		} catch (NullPointerException e) {
			return;
		} finally {
			if (salesReader != null && salesReader1 != null && salesReader2 != null)
				salesReader.close();
				salesReader1.close();
				salesReader2.close();
		}
		

//	private static void model3sales(Sales[] model3) {
//		List<Sales[]> model3L = new ArrayList<>();
//		
//		List<Integer> list = new ArrayList<Integer>();
//		
//		List<Integer> model3S = model3L.stream() 
//																.map(amount -> amount.getNumMonthlySales())
//																.collect(Collectors.toList());
//		
//		model3S.stream().forEach(amount -> System.out.println(amount));
		
		//		List<Sales> model3s = new ArrayList<>();
//		List<Integer> model3L = model3s.stream(); 
		
//		List<Integer> model3Sales1 = model3L.stream()
//					   .map(sale -> sale.getNumMonthlySales()).collect(Collectors.toList());
		
//		model3Sales1.stream().forEach(amount -> System.out.println(amount)); 
//		System.out.println("trap");
	}

}