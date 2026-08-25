// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee 
{
   private String firstName;
   private String lastName;
   private double baseSalary;
   private String jobTitle;

   // three-argument constructor
   public Employee( String first, String last, double salary, String title){
      firstName = first;
      lastName = last;
      baseSalary = salary;
      jobTitle = title;
   } // end three-argument Employee constructor

   //copy constructor
   public Employee(Employee employee) 
   {
      this.firstName = employee.firstName;
      this.lastName = employee.lastName;
      this.baseSalary = employee.baseSalary;
      this.jobTitle = employee.jobTitle;
   }

   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set base salary
   public void setBaseSalary( double salary ) 
   {
      baseSalary = salary;
   }

   // return base salary
   public double getBaseSalary()
   {
      return baseSalary;
   }

   //set job title
   public void setJobTitle( String title )
   {
      jobTitle = title;
   }
   //get job title
   public String getJobTitle()
   {
      return jobTitle;
   }

   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%s %s\njob title: %s\nbase salary: %.2f\n", 
         getFirstName(), getLastName(), getJobTitle(), getBaseSalary() );
   } // end method toString

   //display info method
   public void displayInfo()
   {
      System.out.println(this.toString());
   }

   // abstract method overridden by subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee
