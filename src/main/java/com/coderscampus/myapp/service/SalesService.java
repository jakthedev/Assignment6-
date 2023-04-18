package com.coderscampus.myapp.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
	
	Integer intSum2017SalesValues;
	Integer intSum2018SalesValues;
	Integer intSum2019SalesValues;
	
	List<Integer> finalModelS2016SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelS2017SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelS2018SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelS2019SalesValues = new ArrayList<Integer>();
	
	Integer intlModelSSum2016SalesValues;
	Integer intlModelSSum2017SalesValues;
	Integer intlModelSSum2018SalesValues;
	Integer intlModelSSum2019SalesValues;
	
	List<Integer> finalModelX2016SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelX2017SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelX2018SalesValues = new ArrayList<Integer>();
	List<Integer> finalModelX2019SalesValues = new ArrayList<Integer>();
	
	Integer intlModelXsum2016SalesValues;
	Integer intlModelXsum2017SalesValues;
	Integer intlModelXsum2018SalesValues;
	Integer intlModelXsum2019SalesValues;
	
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
		
		Integer[] yyyy17 = new Integer[modelArray.length];
		List<Integer> cleanedyyyy17 = new ArrayList<Integer>();
		
		for (int i = 0, a = 0; i < modelArray.length; i++) {
			
			if (modelArray[i].getDate().getYear() == 2017) {
				yyyy17[a++] = modelArray[i].getNumMonthlySales();
			}
			
		}
		
		for(Integer s : yyyy17) {
		       if(s != null && s > 0) {
		    	   cleanedyyyy17.add(s);
		       }
		}
		
		for (Integer s : cleanedyyyy17 ) {
			
			if(s != null && s > 0) {
				finalModel32017SalesValues.add(s);
			}
		}
		
		intSum2017SalesValues = (int) finalModel32017SalesValues.stream()
	            .mapToDouble(a -> a)
	            .sum();
		
		return intSum2017SalesValues;	
			}

		public Integer getModel3YearsSum2017() {
			return intSum2017SalesValues;
		}
		
		public Integer setModel3YearsSum2018(Sales[] modelArray) throws NullPointerException {
				
			Integer[] yyyy18 = new Integer[modelArray.length];
			List<Integer> cleanedyyyy18 = new ArrayList<Integer>();
			
			for (int i = 0, a = 0; i < modelArray.length; i++) {
				if (modelArray[i].getDate().getYear() == 2018) {
					yyyy18[a++] = modelArray[i].getNumMonthlySales();
				}
			}
			
			for(Integer s : yyyy18) {
			       if(s != null && s > 0) {
			    	   cleanedyyyy18.add(s);
			       }
			}
			
			for (Integer s : cleanedyyyy18 ) {
				
				if(s != null && s > 0) {
					finalModel32018SalesValues.add(s);
				}
			}
			
			intSum2018SalesValues = (int) finalModel32018SalesValues.stream()
		            .mapToDouble(a -> a)
		            .sum();
			
			return intSum2018SalesValues;	
				}
		
			
			public Integer getModel3YearsSum2018() {
				return intSum2018SalesValues;
			}
			
			public Integer setModel3YearsSum2019(Sales[] modelArray) throws NullPointerException {
							
				Integer[] yyyy19 = new Integer[modelArray.length];
				List<Integer> cleanedyyyy19 = new ArrayList<Integer>();
				
				for (int i = 0, a = 0; i < modelArray.length; i++) {
					
					if (modelArray[i].getDate().getYear() == 2019) {
						yyyy19[a++] = modelArray[i].getNumMonthlySales();
					}
				}
				
				for(Integer s : yyyy19) {
				       if(s != null && s > 0) {
				    	   cleanedyyyy19.add(s);
				       }
				}
				
				for (Integer s : cleanedyyyy19 ) {
					if(s != null && s > 0) {
						finalModel32019SalesValues.add(s);
					}
				}
				
				intSum2019SalesValues = (int) finalModel32019SalesValues.stream()
			            .mapToDouble(a -> a)
			            .sum();
				
				return intSum2019SalesValues;	
					}
			
			public Integer getModel3YearsSum2019() {
				return intSum2019SalesValues;
			}
	// START OF MODEL S YEARLY AMOUNTS 
				
				public Integer setModelSYearsSum2016(Sales[] modelArray) throws NullPointerException {
					
					
					Integer[] yyyy16 = new Integer[modelArray.length];
					List<Integer> cleanedyyyy16 = new ArrayList<Integer>();
					
					for (int i = 0, a = 0; i < modelArray.length; i++) {
						
						if (modelArray[i].getDate().getYear() == 2016) {
							yyyy16[a++] = modelArray[i].getNumMonthlySales();
						}
						
					}
					
					for(Integer s : yyyy16) {
					       if(s != null && s > 0) {
					    	   cleanedyyyy16.add(s);
					       }
					}
					
					for (Integer s : cleanedyyyy16 ) {
						
						if(s != null && s > 0) {
							finalModelS2016SalesValues.add(s);
						}
					}
					
					intlModelSSum2016SalesValues = (int) finalModelS2016SalesValues.stream()
				            .mapToDouble(a -> a)
				            .sum();
					
					return intlModelSSum2016SalesValues;	
						}
				
				public Integer getModelSYearsSum2016() {
					return intlModelSSum2016SalesValues;
				}
				
				public Integer setModelSYearsSum2017(Sales[] modelArray) throws NullPointerException {
					
					
					Integer[] yyyy17 = new Integer[modelArray.length];
					List<Integer> cleanedyyyy17 = new ArrayList<Integer>();
					
					for (int i = 0, a = 0; i < modelArray.length; i++) {
						
						if (modelArray[i].getDate().getYear() == 2017) {
							yyyy17[a++] = modelArray[i].getNumMonthlySales();
						}
						
					}
					
					for(Integer s : yyyy17) {
					       if(s != null && s > 0) {
					    	   cleanedyyyy17.add(s);
					       }
					}
					
					for (Integer s : cleanedyyyy17 ) {
						
						if(s != null && s > 0) {
							finalModelS2017SalesValues.add(s);
						}
					}
					
					intlModelSSum2017SalesValues = (int) finalModelS2017SalesValues.stream()
				            .mapToDouble(a -> a)
				            .sum();
					
					return intlModelSSum2017SalesValues;	
						}
					
					public Integer getModelSYearsSum2017() {
						return intlModelSSum2017SalesValues;
					}
					
					public Integer setModelSYearsSum2018(Sales[] modelArray) throws NullPointerException {
						
						
						Integer[] yyyy18 = new Integer[modelArray.length];
						List<Integer> cleanedyyyy18 = new ArrayList<Integer>();
						
						for (int i = 0, a = 0; i < modelArray.length; i++) {
							
							if (modelArray[i].getDate().getYear() == 2018) {
								yyyy18[a++] = modelArray[i].getNumMonthlySales();
							}
							
						}
						
						for(Integer s : yyyy18) {
						       if(s != null && s > 0) {
						    	   cleanedyyyy18.add(s);
						       }
						}
						
						for (Integer s : cleanedyyyy18 ) {
							
							if(s != null && s > 0) {
								finalModelS2018SalesValues.add(s);
							}
						}
							
							intlModelSSum2018SalesValues = (int) finalModelS2018SalesValues.stream()
						            .mapToDouble(a -> a)
						            .sum();
							
							return intlModelSSum2018SalesValues;	
								}
						
						
						public Integer getModelSYearsSum2018() {
							return intlModelSSum2018SalesValues;
						}
						
						public Integer setModelSYearsSum2019(Sales[] modelArray) throws NullPointerException {
							
							
							Integer[] yyyy19 = new Integer[modelArray.length];
							List<Integer> cleanedyyyy19 = new ArrayList<Integer>();
							
							for (int i = 0, a = 0; i < modelArray.length; i++) {
								
								if (modelArray[i].getDate().getYear() == 2019) {
									yyyy19[a++] = modelArray[i].getNumMonthlySales();
								}
								
							}
							
							for(Integer s : yyyy19) {
							       if(s != null && s > 0) {
							    	   cleanedyyyy19.add(s);
							       }
							}
							
							for (Integer s : cleanedyyyy19 ) {
								
								if(s != null && s > 0) {
									finalModelS2019SalesValues.add(s);
								}
							}
							
							
								intlModelSSum2019SalesValues = (int) finalModelS2019SalesValues.stream()
							            .mapToDouble(a -> a)
							            .sum();
								
								return intlModelSSum2019SalesValues;	
									}
							
							public Integer getModelSYearsSum2019() {
								return intlModelSSum2019SalesValues;
							}
							
		// START OF MODEL X YEARLY AMOUNTS

							public Integer setModelXYearsSum2016(Sales[] modelArray) throws NullPointerException {
								

								Integer[] yyyy16 = new Integer[modelArray.length];
								List<Integer> cleanedyyyy16 = new ArrayList<Integer>();
								
								for (int i = 0, a = 0; i < modelArray.length; i++) {
									
									if (modelArray[i].getDate().getYear() == 2016) {
										yyyy16[a++] = modelArray[i].getNumMonthlySales();
									}
								}
								
								for(Integer s : yyyy16) {
								       if(s != null && s > 0) {
								    	   cleanedyyyy16.add(s);
								       }
								}
								
								for (Integer s : cleanedyyyy16 ) {
									
									if(s != null && s > 0) {
										finalModelX2016SalesValues.add(s);
									}
								}
								
								
									intlModelXsum2016SalesValues = (int) finalModelX2016SalesValues.stream()
								            .mapToDouble(a -> a)
								            .sum();
									
									return intlModelXsum2016SalesValues;	
										}
							
									public Integer getModelXYearsSum2016() {
										return intlModelXsum2016SalesValues;
								}
							
							public Integer setModelXYearsSum2017(Sales[] modelArray) throws NullPointerException {
								
								
								Integer[] yyyy17 = new Integer[modelArray.length];
								List<Integer> cleanedyyyy17 = new ArrayList<Integer>();
								
								for (int i = 0, a = 0; i < modelArray.length; i++) {
									
									if (modelArray[i].getDate().getYear() == 2017) {
										yyyy17[a++] = modelArray[i].getNumMonthlySales();
									}
									
								}
								
								for(Integer s : yyyy17) {
								       if(s != null && s > 0) {
								    	   cleanedyyyy17.add(s);
								       }
								}
								
								for (Integer s : cleanedyyyy17 ) {
									
									if(s != null && s > 0) {
										finalModelX2017SalesValues.add(s);
									}
								}
								
								
									intlModelXsum2017SalesValues = (int) finalModelX2017SalesValues.stream()
								            .mapToDouble(a -> a)
								            .sum();
									
									return intlModelXsum2017SalesValues;	
										}
								
								public Integer getModelXYearsSum2017() {
									return intlModelXsum2017SalesValues;
								}
								
								public Integer setModelXYearsSum2018(Sales[] modelArray) throws NullPointerException {
									
									
									Integer[] yyyy18 = new Integer[modelArray.length];
									List<Integer> cleanedyyyy18 = new ArrayList<Integer>();
									
									for (int i = 0, a = 0; i < modelArray.length; i++) {
										
										if (modelArray[i].getDate().getYear() == 2018) {
											yyyy18[a++] = modelArray[i].getNumMonthlySales();
										}
										
									}
									
									for(Integer s : yyyy18) {
									       if(s != null && s > 0) {
									    	   cleanedyyyy18.add(s);
									       }
									}
									
									for (Integer s : cleanedyyyy18 ) {
										
										if(s != null && s > 0) {
											finalModelX2018SalesValues.add(s);
										}
									}
									
									
										intlModelXsum2018SalesValues = (int) finalModelX2018SalesValues.stream()
									            .mapToDouble(a -> a)
									            .sum();
										
										return intlModelXsum2018SalesValues;	
											}
									
									public Integer getModelXYearsSum2018() {
										return intlModelXsum2018SalesValues;
									}
									
									public Integer setModelXYearsSum2019(Sales[] modelArray) throws NullPointerException {
										
										
										Integer[] yyyy19 = new Integer[modelArray.length];
										List<Integer> cleanedyyyy19 = new ArrayList<Integer>();
										
										for (int i = 0, a = 0; i < modelArray.length; i++) {
											
											if (modelArray[i].getDate().getYear() == 2019) {
												yyyy19[a++] = modelArray[i].getNumMonthlySales();
											}
											
										}
										
										for(Integer s : yyyy19) {
										       if(s != null && s > 0) {
										    	   cleanedyyyy19.add(s);
										       }
										}
										
										for (Integer s : cleanedyyyy19 ) {
											
											if(s != null && s > 0) {
												finalModelX2019SalesValues.add(s);
											}
										}
										
										
											intlModelXsum2019SalesValues = (int) finalModelX2019SalesValues.stream()
										            .mapToDouble(a -> a)
										            .sum();
											
											return intlModelXsum2019SalesValues;	
												}
										
										public Integer getModelXYearsSum2019() {
											return intlModelXsum2019SalesValues;
										}
		

}
