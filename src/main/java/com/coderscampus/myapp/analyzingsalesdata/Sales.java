

public class Sales {
    private String salesMonth;
    private Integer salesYear;
    private Integer numMonthlySales;


    public Sales(String salesMonth, Integer salesYear, Integer numMonthlySales) {
        this.numMonthlySales = numMonthlySales;
        this.salesMonth = salesMonth;
        this.salesYear = salesYear;
    }

    public String getSalesMonth(){
        return salesMonth;
    }

    public String getSalesYear(){
        return salesYear;
    }

    public String getnumMonthlySales(){
        return numMonthlySales;
    }

    public void setnumMonthlySales(Integer numMonthlySales){
        this.numMonthlySales = numMonthlySales;
    }

    public void setSalesMonth(String salesMonth){
        this.salesMonth = salesMonth;
    }

    public void setSalesYear(String salesYear){
        this.salesYear = salesYear;
    }

    public String toString() {
        return "Monthly sales for " + salesMonth + " were " + numMonthlySales + " " +
                "in the year of " + salesYear;
    }
}