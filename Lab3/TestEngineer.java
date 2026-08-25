/*
 * Vincent Fealy
 * Lab 3
 */

 public class TestEngineer extends TechnicalStaff
 {

    public TestEngineer(String first, String last, double salary, String title, double profit){
        super(first, last, salary, title, profit);
    }

    public TestEngineer(TestEngineer testEngineer){
        super(testEngineer.getFirstName(), testEngineer.getLastName(), testEngineer.getBaseSalary(), testEngineer.getJobTitle(), testEngineer.getProfitShare());
    }

    public double earnings(){
        return super.earnings();
    }

    public String toString(){
        return super.toString();
    }

    public void displayInfo(){
        System.out.println(this.toString());
    }

 }