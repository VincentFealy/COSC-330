/*
 * Vincent Fealy
 * Lab3
 */

 public class Manager extends Employee
 {
    private double bonusPay;

    public Manager(String first, String last, double salary, String title, double bonus){
        super(first, last, salary, title);
        bonusPay = bonus;        
    }

    public Manager(Manager manager) {
        super(manager.getFirstName(), manager.getLastName(), manager.getBaseSalary(), manager.getJobTitle());
        this.bonusPay = manager.bonusPay;
    }

    public double getBonusPay(){
        return bonusPay;
    }

    public void setBonusPay(double bonus){
        bonusPay = bonus;
    }

    public double earnings() {
        return getBonusPay() + getBaseSalary();
    }

    public String toString(){
        return super.toString() + String.format("bonus pay: %.2f\n", getBonusPay());
    }

    public void displayInfo(){
        System.out.println(this.toString());
    }

 }