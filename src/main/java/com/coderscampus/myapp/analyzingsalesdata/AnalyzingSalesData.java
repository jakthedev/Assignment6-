package com.coderscampus.myapp.analyzingsalesdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import com.coderscampus.myapp.service.SalesService;

public class AnalyzingSalesData {

    public static void main(String[] args) throws IOException{
    	
    	Sales[] model3 = new Sales[100];

        BufferedReader salesReader = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
        int i = 0;

        try {
            salesReader = new BufferedReader(new FileReader("model3.csv"));
            salesReader.readLine();
 
            
            while (salesReader != null) {
                String model3Info = salesReader.readLine();
                String[] modelstr = model3Info.split(","); 
                
                // stream a if() in to where year is to match the constant status(year) it should go to
                Sales sale = SalesService.createSalesData(YearMonth.parse(modelstr[0], formatter), 
                		Integer.valueOf(modelstr[1]));
                
                System.out.println(sale.toString());
                model3[i++] = sale; 
                //System.out.println(i);
                
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
}