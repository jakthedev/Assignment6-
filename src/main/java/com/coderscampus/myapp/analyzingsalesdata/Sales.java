package com.coderscampus.myapp.analyzingsalesdata;

import com.coderscampus.myapp.analyzingsalesdata.Year;

public class Sales {
    private String salesMonth;
    private Year salesYear;
    private Integer numMonthlySales;


    public Sales(String salesMonth, Year salesYear, Integer numMonthlySales) {
        this.numMonthlySales = numMonthlySales;
        this.salesMonth = salesMonth;
        salesYear = Year.DEFAULT;
    }

    public String getSalesMonth(){
        return salesMonth;
    }

    public Year getSalesYear(){
        return salesYear;
    }

    public Integer getnumMonthlySales(){
        return numMonthlySales;
    }

    public void setnumMonthlySales(Integer numMonthlySales){
        this.numMonthlySales = numMonthlySales;
    }

    public void setSalesMonth(String salesMonth){
        this.salesMonth = salesMonth;
    }

    public void setSalesYear(Year salesYear){
        this.salesYear = salesYear;
    }

    public String toString() {
        return "Monthly sales for " + salesMonth + " were " + numMonthlySales + " " +
                "in the year of " + salesYear;
    }
}