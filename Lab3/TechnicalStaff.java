/*
 * Vincent Fealy
 Lab 3
 * 
 */

 public class TechnicalStaff extends Employee
 {
    private double profitShare;

    public TechnicalStaff(String first, String last, double salary, String title, double profit){
        super( first, last, salary, title);
        profitShare = profit;
    }

    public TechnicalStaff(TechnicalStaff technicalStaff){
        super(technicalStaff.getFirstName(), technicalStaff.getLastName(), technicalStaff.getBaseSalary(), technicalStaff.getJobTitle());
        this.profitShare = technicalStaff.profitShare;
    }

    public double getProfitShare(){
        return profitShare;
    }

    public void setProfitShare(double profit){
        profitShare = profit;
    }

    public double earnings(){
        return getBaseSalary() + getProfitShare();
    }

    public String toString(){
        return super.toString() + String.format("profit share: %.2f\n", getProfitShare());
    }

    public void displayInfo(){
        System.out.println(this.toString());
    }
 }