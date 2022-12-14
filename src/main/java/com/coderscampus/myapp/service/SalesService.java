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
	Sales[] finalCleanedmodelSS;
	Sales[] finalCleanedmodelXS;

	BufferedReader salesReader = null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");

	//FileService fileservice = new FileService();

//	Sales[] model3A = fileservice.getModel3();
//	Sales[] modelSA = fileservice.getModelS();
//	Sales[] modelSX = fileservice.getModelX();

	int i = 0;
	int j = 0;
	int d = 0;

	public static Sales createSalesData(YearMonth date, Integer numMonthlySales) {
		Sales saleInfo = new Sales();
		saleInfo.setDate(date);
		saleInfo.setNumMonthlySales(numMonthlySales);
		return saleInfo;
	}

	public Sales[] sortModel3Array(Sales[] modelArray) {

		List<Sales> model3S = Arrays.stream(modelArray).collect(Collectors.toList());
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

	public Sales[] sortModelSArray(Sales[] modelArray) {

		List<Sales> modelSS = Arrays.stream(modelArray).collect(Collectors.toList());
		modelSS.sort((o2, o1) -> o1.getNumMonthlySales().compareTo(o2.getNumMonthlySales()));

		Sales bmM3 = modelSS.get(0);
		System.out.println("The best month for Model S was " + bmM3.toStringMS());
		Sales wmM3 = modelSS.get(modelSS.size() - 1);
		System.out.println("The worst month for Model S was " + wmM3.toStringMS());

		Sales[] finalCleanedmodelSS = modelSS.toArray(new Sales[0]);

		return finalCleanedmodelSS;
	}

	public Sales[] getFinalCleanedModelS() {
		return finalCleanedmodelSS;
	}

	public Sales[] sortModelXArray(Sales[] modelArray) {

		List<Sales> modelXS = Arrays.stream(modelArray).collect(Collectors.toList());
		modelXS.sort((o2, o1) -> o1.getNumMonthlySales().compareTo(o2.getNumMonthlySales()));

		Sales bmMX = modelXS.get(0);
		System.out.println("The best month for Model X was " + bmMX.toStringMX());
		Sales wmMX = modelXS.get(modelXS.size() - 1);
		System.out.println("The worst month for Model X was " + wmMX.toStringMX());

		Sales[] finalCleanedmodelXS = modelXS.toArray(new Sales[0]);

		return finalCleanedmodelXS;
	}

	public Sales[] getFinalCleanedModelX() {
		return finalCleanedmodelXS;
	}

}
