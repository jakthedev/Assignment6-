package com.coderscampus.myapp.analyzingsalesdata;

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

import com.coderscampus.myapp.service.SalesService;

public class AnalyzingSalesData {

	public static void main(String[] args) throws IOException {

		Sales[] model3 = new Sales[29];
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

			salesReader.readLine();

			while (salesReader != null) {

				String model3Info = salesReader.readLine();
				String[] modelstr = model3Info.split(",");

				Sales sale = SalesService.createSalesData(YearMonth.parse(modelstr[0], formatter),
						Integer.valueOf(modelstr[1]));

				model3[i++] = sale;
				//System.out.println(i);
				if (i == 29) {
					break;
				}
			}

			salesReader1 = new BufferedReader(new FileReader("modelS.csv"));

			salesReader1.readLine();

			while (salesReader1 != null) {

				String modelSInfo = salesReader1.readLine();
				String[] modelstr1 = modelSInfo.split(",");

				Sales sale2 = SalesService.createSalesData(YearMonth.parse(modelstr1[0], formatter),
						Integer.valueOf(modelstr1[1]));

				// System.out.println(sale2.toStringMS());
				modelS[j++] = sale2;
				//System.out.println(j);
				if (j == 48) {
					break;
				}
			}

			salesReader2 = new BufferedReader(new FileReader("modelX.csv"));

			salesReader2.readLine();

			while (salesReader2 != null) {
				String modelXInfo = salesReader2.readLine();
				String[] modelstr2 = modelXInfo.split(",");

				Sales sale3 = SalesService.createSalesData(YearMonth.parse(modelstr2[0], formatter),
						Integer.valueOf(modelstr2[1]));

				//System.out.println(sale3.toStringMX());
				modelX[d++] = sale3;
				//System.out.println(d);
				if (d == 48) {
					break;
				}
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			return;
		} finally {
			salesReader.close();
			salesReader1.close();
			salesReader2.close();
		}

		
		BufferedWriter writer = null;

		List<Sales> model3S = Arrays.stream(model3).collect(Collectors.toList());
		model3S.sort((o2, o1) -> o1.getNumMonthlySales().compareTo(o2.getNumMonthlySales()));

		Sales bmM3 = model3S.get(0);
		System.out.println("The best month for Model 3 was " + bmM3.toStringMS());
		Sales wmM3 = model3S.get(model3S.size() - 1);
		System.out.println("The worst month for Model 3 was " + wmM3.toStringMS());

		Sales[] finalCleanedmodel3S = model3S.toArray(new Sales[0]); 
		

		try {

			writer = new BufferedWriter(new FileWriter("model3New.csv"));
			writer.write("Date,Sales\n");
			
			for (int a = 0; a < finalCleanedmodel3S.length; a++) {
	
				writer.write(
						String.valueOf(finalCleanedmodel3S[a].getDate()) + "," 
				+ finalCleanedmodel3S[a].getNumMonthlySales() + "\n");
			}
			} finally {
			writer.close();
		}
		
		BufferedWriter writer1 = null;

		List<Sales> modelSS = Arrays.stream(modelS).collect(Collectors.toList());
		modelSS.sort((o2, o1) -> o1.getNumMonthlySales().compareTo(o2.getNumMonthlySales()));

		Sales bmMs = modelSS.get(0);
		System.out.println("The best month for Model S was " + bmMs.toStringMS());
		Sales wmMs = modelSS.get(model3S.size() - 1);
		System.out.println("The worst month for Model S was " + wmMs.toStringMS());

		Sales[] finalCleanedmodelSS = model3S.toArray(new Sales[0]); 
		

		try {

			writer1 = new BufferedWriter(new FileWriter("modelSNew.csv"));
			writer1.write("Date,Sales\n");
			
			for (int a = 0; a < finalCleanedmodelSS.length; a++) {
	
				writer1.write(
						String.valueOf(finalCleanedmodelSS[a].getDate()) + "," 
				+ finalCleanedmodelSS[a].getNumMonthlySales() + "\n");
			}
			} finally {
			writer1.close();
		}
		
		BufferedWriter writer2 = null;

		List<Sales> modelXS = Arrays.stream(modelX).collect(Collectors.toList());
		modelXS.sort((o2, o1) -> o1.getNumMonthlySales().compareTo(o2.getNumMonthlySales()));

		Sales bmXs = modelXS.get(0);
		System.out.println("The best month for Model X was " + bmXs.toStringMS());
		Sales wmXs = modelSS.get(model3S.size() - 1);
		System.out.println("The worst month for Model X was " + wmXs.toStringMS());

		Sales[] finalCleanedmodelXS = model3S.toArray(new Sales[0]); 
		

		try {

			writer2 = new BufferedWriter(new FileWriter("modelXNew.csv"));
			writer2.write("Date,Sales\n");
			
			for (int a = 0; a < finalCleanedmodelXS.length; a++) {
	
				writer2.write(
						String.valueOf(finalCleanedmodelXS[a].getDate()) + "," 
				+ finalCleanedmodelXS[a].getNumMonthlySales() + "\n");
			}
			} finally {
			writer2.close();
		}
	}
}
