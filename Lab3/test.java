/*
 * Vincent Fealy
 */

 public class test {

    public static void main(String[] args) {

        //Create an array of 3 employee types executive, software engineer, test engineer
        Employee employeeArray[] = new Employee[3];

        Executive executive = new Executive("John", "Doe", 100000, "Executive", 5000, 2000);
        SoftwareEngineer softwareEngineer = new SoftwareEngineer("Connor", "Smith", 75000, "Software Engineer", 2500, 5000);
        TestEngineer testEngineer = new TestEngineer("Vincent", "Fealy",  50000, "Test Engineer", 5000);

        employeeArray[0] = executive;
        employeeArray[1] = softwareEngineer;
        employeeArray[2] = testEngineer;


        //Calling method to display employees
        System.out.println("Printing employeeArray[0]");
        employeeArray[0].displayInfo();
        
        System.out.println("Printing employeeArray[1]");
        employeeArray[1].displayInfo();
        
        System.out.println("Printing employeeArray[2]");
        employeeArray[2].displayInfo();

        //display employees methods
        System.out.println("Printing executive");
        executive.displayInfo();

        System.out.println("Printing softwareEngineer");
        softwareEngineer.displayInfo();

        System.out.println("Printing testEngineer");
        testEngineer.displayInfo();

    }
}
 