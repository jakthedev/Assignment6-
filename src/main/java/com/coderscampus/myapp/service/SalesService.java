package com.coderscampus.myapp.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.coderscampus.myapp.analyzingsalesdata.Sales;
import com.coderscampus.myapp.service.FileService;
import com.coderscampus.myapp.analyzingsalesdata.Year;

public class SalesService {

	Sales[] finalCleanedmodel3S;
	Sales[] finalCleanedmodelSS;
	Sales[] finalCleanedmodelXS;
	
	List<Integer> finalModel32017SalesValues = new ArrayList<Integer>();
	List<Integer> finalModel32018SalesValues = new ArrayList<Integer>();
	List<Integer> finalModel32019SalesValues = new ArrayList<Integer>();
	
	List<Integer> finalModelS2016SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelS2017SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelS2018SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelS2019SalesValues = new ArrayList<Integer>();
	
	List<Integer> finalModelX2016SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelX2017SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelX2018SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelX2019SalesValues = new ArrayList<Integer>();
	
	Integer sum2017Model3_Sales;
	Integer sum2018Model3_Sales;
	Integer sum2019Model3_Sales;
	
	Integer sum2016ModelS_Sales;
	Integer sum2017ModelS_Sales;
	Integer sum2018ModelS_Sales;
	Integer sum2019ModelS_Sales;
	
	Integer sum2016ModelX_Sales;
	Integer sum2017ModelX_Sales;
	Integer sum2018ModelX_Sales;
	Integer sum2019ModelX_Sales;
	
	

	BufferedReader salesReader = null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");

	int i = 0;
	int j = 0;
	int d = 0;
	
	public Integer theSum2017Sales;
	

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
		System.out.println("The best month for Model 3 was " + bmM3.toStringM3());
		Sales wmM3 = model3S.get(model3S.size() - 1);
		System.out.println("The worst month for Model 3 was " + wmM3.toStringM3());

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
	
	// START OF MODEL 3 YEARLY AMOUNTS

	public Sales[] getFinalCleanedModelX() {
		return finalCleanedmodelXS;
	}
	
	public Integer setModel3YearsSum2017(Sales[] modelArray) throws NullPointerException {
		
		
		Integer[] year2017numbers = new Integer[modelArray.length];
		for (int i = 0; i < modelArray.length; i++) {
			
			if (modelArray[i].getDate().getYear() == 2017) {
				int yyyy17 = modelArray[i].getNumMonthlySales();
				year2017numbers[i++] = yyyy17;
			}
			
			for (Integer s : year2017numbers ) {
				if(s != null && s > 0) {
					finalModel32017SalesValues.add(s);
				}
			}
		}
		
		for(Integer v : finalModel32017SalesValues) {
			sum2017Model3_Sales = IntStream.of(v).sum();
			}
		return sum2017Model3_Sales;	
			}
		
		public Integer getModel3YearsSum2017() {
			return sum2017Model3_Sales;
		}
		
		public Integer setModel3YearsSum2018(Sales[] modelArray) throws NullPointerException {
			
			
			Integer[] year2018numbers = new Integer[modelArray.length];
			for (int i = 0; i < modelArray.length; i++) {
				
				if (modelArray[i].getDate().getYear() == 2018) {
					int yyyy18 = modelArray[i].getNumMonthlySales();
					year2018numbers[i++] = yyyy18;
				}
				
				for (Integer s : year2018numbers ) {
					if(s != null && s > 0) {
						finalModel32017SalesValues.add(s);
					}
				}
			}
			
			for(Integer v : finalModel32017SalesValues) {
				sum2018Model3_Sales = IntStream.of(v).sum();
				}
			
			return sum2018Model3_Sales;
			
				}
			
			public Integer getModel3YearsSum2018() {
				return sum2018Model3_Sales;
			}
			
			public Integer setModel3YearsSum2019(Sales[] modelArray) throws NullPointerException {
				
				
				Integer[] year2019numbers = new Integer[modelArray.length];
				for (int i = 0; i < modelArray.length; i++) {
					
					if (modelArray[i].getDate().getYear() == 2019) {
						int yyyy19 = modelArray[i].getNumMonthlySales();
						year2019numbers[i++] = yyyy19;
					}
					
					for (Integer s : year2019numbers ) {
						if(s != null && s > 0) {
							finalModel32017SalesValues.add(s);
						}
					}
				}
				
				for(Integer v : finalModel32017SalesValues) {
					sum2019Model3_Sales = IntStream.of(v).sum();
					}
				
				return sum2019Model3_Sales;
				
					}
				
				public Integer getModel3YearsSum2019() {
					return sum2019Model3_Sales;
				}
	// START OF MODEL S YEARLY AMOUNTS 
				
				public Integer setModelSYearsSum2016(Sales[] modelArray) throws NullPointerException {
					
					
					Integer[] year2016numbers = new Integer[modelArray.length];
					for (int i = 0; i < modelArray.length; i++) {
						
						if (modelArray[i].getDate().getYear() == 2016) {
							int yyyy16 = modelArray[i].getNumMonthlySales();
							year2016numbers[i++] = yyyy16;
						}
						
						for (Integer s : year2016numbers ) {
							if(s != null && s > 0) {
								finalModelS2016SalesValues.add(s);
							}
						}
					}
					
					for(Integer v : finalModelS2016SalesValues) {
						sum2016ModelS_Sales = IntStream.of(v).sum();
						}
					return sum2016ModelS_Sales;	
						}
					
					public Integer getModelSYearsSum2016() {
						return sum2016ModelS_Sales;
					}
				
				public Integer setModelSYearsSum2017(Sales[] modelArray) throws NullPointerException {
					
					
					Integer[] year2017numbers = new Integer[modelArray.length];
					for (int i = 0; i < modelArray.length; i++) {
						
						if (modelArray[i].getDate().getYear() == 2017) {
							int yyyy17 = modelArray[i].getNumMonthlySales();
							year2017numbers[i++] = yyyy17;
						}
						
						for (Integer s : year2017numbers ) {
							if(s != null && s > 0) {
								finalModelS2017SalesValues.add(s);
							}
						}
					}
					
					for(Integer v : finalModelS2017SalesValues) {
						sum2017ModelS_Sales = IntStream.of(v).sum();
						}
					return sum2017ModelS_Sales;	
						}
					
					public Integer getModelSYearsSum2017() {
						return sum2017ModelS_Sales;
					}
					
					public Integer setModelSYearsSum2018(Sales[] modelArray) throws NullPointerException {
						
						
						Integer[] year2018numbers = new Integer[modelArray.length];
						for (int i = 0; i < modelArray.length; i++) {
							
							if (modelArray[i].getDate().getYear() == 2018) {
								int yyyy18 = modelArray[i].getNumMonthlySales();
								year2018numbers[i++] = yyyy18;
							}
							
							for (Integer s : year2018numbers ) {
								if(s != null && s > 0) {
									finalModelS2018SalesValues.add(s);
								}
							}
						}
						
						for(Integer v : finalModelS2018SalesValues) {
							sum2018ModelS_Sales = IntStream.of(v).sum();
							}
						
						return sum2018ModelS_Sales;
						
							}
						
						public Integer getModelSYearsSum2018() {
							return sum2018ModelS_Sales;
						}
						
						public Integer setModelSYearsSum2019(Sales[] modelArray) throws NullPointerException {
							
							
							Integer[] year2019numbers = new Integer[modelArray.length];
							for (int i = 0; i < modelArray.length; i++) {
								
								if (modelArray[i].getDate().getYear() == 2019) {
									int yyyy19 = modelArray[i].getNumMonthlySales();
									year2019numbers[i++] = yyyy19;
								}
								
								for (Integer s : year2019numbers ) {
									if(s != null && s > 0) {
										finalModelS2019SalesValues.add(s);
									}
								}
							}
							
							for(Integer v : finalModelS2019SalesValues) {
								sum2019ModelS_Sales = IntStream.of(v).sum();
								}
							
							return sum2019ModelS_Sales;
							
								}
							
							public Integer getModelSYearsSum2019() {
								return sum2019ModelS_Sales;
							}
							
		// START OF MODEL X YEARLY AMOUNTS

							public Integer setModelXYearsSum2016(Sales[] modelArray) throws NullPointerException {
								
								
								Integer[] year2016numbers = new Integer[modelArray.length];
								for (int i = 0; i < modelArray.length; i++) {
									
									if (modelArray[i].getDate().getYear() == 2016) {
										int yyyy16 = modelArray[i].getNumMonthlySales();
										year2016numbers[i++] = yyyy16;
									}
									
									for (Integer s : year2016numbers ) {
										if(s != null && s > 0) {
											finalModelX2016SalesValues.add(s);
										}
									}
								}
								
								for(Integer v : finalModelX2016SalesValues) {
									sum2016ModelX_Sales = IntStream.of(v).sum();
									}
								return sum2016ModelX_Sales;	
									}
								
								public Integer getModelXYearsSum2016() {
									return sum2016ModelX_Sales;
								}
							
							public Integer setModelXYearsSum2017(Sales[] modelArray) throws NullPointerException {
								
								
								Integer[] year2017numbers = new Integer[modelArray.length];
								for (int i = 0; i < modelArray.length; i++) {
									
									if (modelArray[i].getDate().getYear() == 2017) {
										int yyyy17 = modelArray[i].getNumMonthlySales();
										year2017numbers[i++] = yyyy17;
									}
									
									for (Integer s : year2017numbers ) {
										if(s != null && s > 0) {
											finalModelX2017SalesValues.add(s);
										}
									}
								}
								
								for(Integer v : finalModelX2017SalesValues) {
									sum2017ModelX_Sales = IntStream.of(v).sum();
									}
								return sum2017ModelX_Sales;	
									}
								
								public Integer getModelXYearsSum2017() {
									return sum2017ModelX_Sales;
								}
								
								public Integer setModelXYearsSum2018(Sales[] modelArray) throws NullPointerException {
									
									
									Integer[] year2018numbers = new Integer[modelArray.length];
									for (int i = 0; i < modelArray.length; i++) {
										
										if (modelArray[i].getDate().getYear() == 2018) {
											int yyyy18 = modelArray[i].getNumMonthlySales();
											year2018numbers[i++] = yyyy18;
										}
										
										for (Integer s : year2018numbers ) {
											if(s != null && s > 0) {
												finalModelX2018SalesValues.add(s);
											}
										}
									}
									
									for(Integer v : finalModelX2018SalesValues) {
										sum2018ModelX_Sales = IntStream.of(v).sum();
										}
									
									return sum2018ModelX_Sales;
									
										}
									
									public Integer getModelXYearsSum2018() {
										return sum2018ModelX_Sales;
									}
									
									public Integer setModelXYearsSum2019(Sales[] modelArray) throws NullPointerException {
										
										
										Integer[] year2019numbers = new Integer[modelArray.length];
										for (int i = 0; i < modelArray.length; i++) {
											
											if (modelArray[i].getDate().getYear() == 2019) {
												int yyyy19 = modelArray[i].getNumMonthlySales();
												year2019numbers[i++] = yyyy19;
											}
											
											for (Integer s : year2019numbers ) {
												if(s != null && s > 0) {
													finalModelX2019SalesValues.add(s);
												}
											}
										}
										
										for(Integer v : finalModelX2019SalesValues) {
											sum2019ModelX_Sales = IntStream.of(v).sum();
											}
										
										return sum2019ModelX_Sales;
										
											}
										
										public Integer getModelXYearsSum2019() {
											return sum2019ModelX_Sales;
										}
		

}
