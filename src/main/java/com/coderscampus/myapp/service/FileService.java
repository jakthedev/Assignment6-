package com.coderscampus.myapp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.coderscampus.myapp.analyzingsalesdata.Sales;

public class FileService {

	Sales[] model3 = new Sales[29];
	Sales[] modelS = new Sales[48];
	Sales[] modelX = new Sales[48];

	BufferedReader salesReader = null;
	BufferedWriter writer = null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");

	//SalesService salesService = new SalesService();

	int i = 0;
	int j = 0;
	int d = 0;

	public Sales[] readingModel3Data() throws IOException {
		try {
			salesReader = new BufferedReader(new FileReader("model3.csv"));

			salesReader.readLine();

			while (salesReader != null) {

				String model3Info = salesReader.readLine();
				String[] modelstr = model3Info.split(",");

				Sales sale = SalesService.createSalesData(YearMonth.parse(modelstr[0], formatter),
						Integer.valueOf(modelstr[1]));

				model3[i++] = sale;
				// System.out.println(i);
				if (i == 29) {
					break;
				}
			}
		} finally {
			salesReader.close();
		}
		return model3;
	}

	public Sales[] getModel3() {
		return model3;
	}

	public Sales[] readingModelSData() throws IOException {
		salesReader = new BufferedReader(new FileReader("modelS.csv"));

		salesReader.readLine();

		while (salesReader != null) {

			String modelSInfo = salesReader.readLine();
			String[] modelstr1 = modelSInfo.split(",");

			Sales sale2 = SalesService.createSalesData(YearMonth.parse(modelstr1[0], formatter),
					Integer.valueOf(modelstr1[1]));

			// System.out.println(sale2.toStringMS());
			modelS[j++] = sale2;
			// System.out.println(j);
			if (j == 48) {
				break;
			}
		}
		return modelS;
	}

	public Sales[] getModelS() {
		return model3;
	}
	
	public Sales[] readingModelXData() throws IOException {
		salesReader = new BufferedReader(new FileReader("modelX.csv"));

		salesReader.readLine();

		while (salesReader != null) {
			String modelXInfo = salesReader.readLine();
			String[] modelstr2 = modelXInfo.split(",");

			Sales sale3 = SalesService.createSalesData(YearMonth.parse(modelstr2[0], formatter),
					Integer.valueOf(modelstr2[1]));

			// System.out.println(sale3.toStringMX());
			modelX[d++] = sale3;
			// System.out.println(d);
			if (d == 48) {
				break;
			}
		}
		return modelX;
	}
	
	public Sales[] getModelX() {
		return modelX;
	}

	public void writesModel3DataToCsv(Sales[] finalCleanedmodel) throws IOException {

		try {

			writer = new BufferedWriter(new FileWriter("model3New.csv"));
			writer.write("Date,Sales\n");

			for (int a = 0; a < finalCleanedmodel.length; a++) {

				writer.write(String.valueOf(finalCleanedmodel[a].getDate()) + ","
						+ finalCleanedmodel[a].getNumMonthlySales() + "\n");
			}
		} finally {
			writer.close();
		}
	}
	
	public void writesModelXDataToCsv(Sales[] finalCleanedmodel) throws IOException {
		
		try {

			writer = new BufferedWriter(new FileWriter("modelXNew.csv"));
			writer.write("Date,Sales\n");

			for (int a = 0; a < finalCleanedmodel.length; a++) {

				writer.write(String.valueOf(finalCleanedmodel[a].getDate()) + ","
						+ finalCleanedmodel[a].getNumMonthlySales() + "\n");
			}
		} finally {
			writer.close();
		}
	}
	
	public void writesModelSDataToCsv(Sales[] finalCleanedmodel) throws IOException {
		
		try {

			writer = new BufferedWriter(new FileWriter("modelSNew.csv"));
			writer.write("Date,Sales\n");

			for (int a = 0; a < finalCleanedmodel.length; a++) {

				writer.write(String.valueOf(finalCleanedmodel[a].getDate()) + ","
						+ finalCleanedmodel[a].getNumMonthlySales() + "\n");
			}
		} finally {
			writer.close();
		}
	}
}
