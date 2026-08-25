/*
 * Vincent Fealy
 * Lab 3
 */

 public class SoftwareEngineer extends TechnicalStaff
 {
    private double overtimePay;

    public SoftwareEngineer(String first, String last, double salary, String title, double profit, double ot)
    {
        super(first, last, salary, title, profit);

        overtimePay = ot;
    }

    public SoftwareEngineer(SoftwareEngineer softwareEngineer){
        super(softwareEngineer.getFirstName(), softwareEngineer.getLastName(), softwareEngineer.getBaseSalary(), softwareEngineer.getJobTitle(), softwareEngineer.getProfitShare());
        this.overtimePay = softwareEngineer.overtimePay;
    }

    public double getOvertimePay(){
        return overtimePay;
    }

    public void setOvertimePay(double ot){
        overtimePay = ot;
    }

    public double earnings(){
        return super.earnings() + getOvertimePay();
    }

    public String toString(){
        return super.toString() + String.format("overtime pay: %.2f\n", getOvertimePay());
    }

    public void displayInfo(){
        System.out.println(this.toString());
    }
    
 }