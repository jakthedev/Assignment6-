package com.coderscampus.myapp.analyzingsalesdata;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import com.coderscampus.myapp.analyzingsalesdata.Year;

public class Sales {
	private YearMonth date;
    private Integer numMonthlySales; 


    public Sales(YearMonth date, Integer numMonthlySales) {
        this.numMonthlySales = numMonthlySales;
        this.date = date;
        
    }
    
    public YearMonth getDate(YearMonth date) {
        return date;
    }

    public void setDate(YearMonth date){
        this.date = date;
    }

    public Integer getNumMonthlySales() {
        return numMonthlySales;
    }

    public void setNumMonthlySales(Integer numMonthlySales){
        this.numMonthlySales = numMonthlySales;
    } 

    public String toStringM3() {
        return "For the date of  " + date + " Tesla sold " + numMonthlySales + " for the model3 ";
    }
    
    public String toStringMS() {
        return "For the date of  " + date + " Tesla sold " + numMonthlySales + " for the modelS ";
    }
    
    public String toStringMX() {
        return "For the date of  " + date + " Tesla sold " + numMonthlySales + " for the modelX ";
    }
}