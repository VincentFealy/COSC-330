/*
 * Vincent Fealy
 * Lab 3
 * 
 */

 public class Executive extends Manager
 {
    private double stockOption;

    public Executive(String first, String last, double salary, String title, double bonus, double stock){
        super(first, last, salary, title, bonus);
        stockOption = stock;
    }

    public Executive(Executive executive) {
        super(executive.getFirstName(), executive.getLastName(), executive.getBaseSalary(), executive.getJobTitle(), executive.getBonusPay());
        this.stockOption = executive.stockOption;
    }

    public void setStockOption(double stock){
        stockOption = stock;
    }

    public double getStockOption(){
        return stockOption;
    }

    public double earnings(){
        return super.earnings() + getStockOption();
    }


    public String toString(){
        return super.toString() + String.format("stock option: %.2f\n", getStockOption());
    }

    public void displayInfo(){
        System.out.println(this.toString());
    }

 }