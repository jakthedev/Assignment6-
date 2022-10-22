package com.coderscampus.myapp.analyzingsalesdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalyzingSalesData {

    public static void main(String[] args) throws IOException{
    	
    	System.out.println("things are working ");
    	
    	List<Sales> model3 = new ArrayList<>();

        BufferedReader salesReader = null;

        try {
            salesReader = new BufferedReader(new FileReader("model3.csv"));
            //salesReader.readline();
            
            while (salesReader.readLine() != null) {
                String model3Info = salesReader.readLine();
                String[] allModel3Info = model3Info.split(",");
            }
    } finally{

    	
    }
    }
}