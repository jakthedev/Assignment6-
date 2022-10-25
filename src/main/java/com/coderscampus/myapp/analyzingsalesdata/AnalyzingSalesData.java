package com.coderscampus.myapp.analyzingsalesdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import com.coderscampus.myapp.service.SalesService;

public class AnalyzingSalesData {
	
	private static void readModelSFile(BufferedReader salesReader) throws FileNotFoundException, IOException {
		Sales[] modelS = new Sales[48];

        BufferedReader salesReader1 = null;
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM-yy");
        int j = 0;

        try {
            salesReader1 = new BufferedReader(new FileReader("modelS.csv"));
            salesReader1.readLine();
 
            while (salesReader1 != null) {
                String modelSInfo = salesReader1.readLine();
                String[] modelstr1 = modelSInfo.split(","); 
                
                // stream a if() in to where year is to match the constant status(year) it should go to
                Sales sale1 = SalesService.createSalesData(YearMonth.parse(modelstr1[0], formatter1), 
                		Integer.valueOf(modelstr1[1]));
                
                System.out.println(sale1.toStringMS());
                modelS[j++] = sale1; 
                //System.out.println(j);
            } 
        }
            catch(NullPointerException e ){
                return;
            }     
     finally{
    	if (salesReader != null)
    		salesReader.close();	
    }
	}

    public static void main(String[] args) throws IOException{
    	
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
                
                String modelSInfo = salesReader.readLine();
                String[] modelstr1 = modelSInfo.split(","); 
                
                String modelXInfo = salesReader.readLine();
                String[] modelstr2 = modelXInfo.split(",");
                
                // stream a if() in to where year is to match the constant status(year) it should go to
                Sales sale = SalesService.createSalesData(YearMonth.parse(modelstr[0], formatter), 
                		Integer.valueOf(modelstr[1])); 
                
                Sales sale2 = SalesService.createSalesData(YearMonth.parse(modelstr1[0], formatter), 
                		Integer.valueOf(modelstr1[1])); 
                
                Sales sale3 = SalesService.createSalesData(YearMonth.parse(modelstr2[0], formatter), 
                		Integer.valueOf(modelstr2[1]));
                
                //System.out.println(sale.toStringM3());
                model3[i++] = sale; 
                //System.out.println(i);
                
              System.out.println(sale.toStringMS());
                modelS[j++] = sale2; 
                //System.out.println(i);
                
              //System.out.println(sale.toStringMX());
                modelX[d++] = sale3; 
                //System.out.println(i);
            } 
        }
            catch(NullPointerException e ){
                return;
            }     
     finally{
    	if (salesReader != null && salesReader1 != null && salesReader2 != null)
    		salesReader.close(); 
    	    salesReader1.close(); 
    	    salesReader2.close();
    }
        
        
        
        
   }


}