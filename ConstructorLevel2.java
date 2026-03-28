/*
LEVEL 2(Logic Building)
Question 2: Employee Salary Update

Create a class Employee with:
int empId
String name
double salary

-Constructor to initialize

-Method:
increaseSalary(double percentage)

-Increase salary based on percentage
-Display updated details

Example:
Salary = 10000
Increase = 10%
New Salary = 11000
*/

import java.util.*;

public class ConstructorLevel2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        
        Employee emp = new Employee(empId, name, salary);
        
        System.out.print("Enter Salary Increase Percentage: ");
        double percentage = sc.nextDouble();
        
        emp.increaseSalary(percentage);
        emp.displayDetails();
        
        sc.close();
    }   
}

class Employee{
    int empId;
    String name;
    double salary;
    double newSalary ;

    Employee(int empId, String name,double salary){
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double per){
        double addOn = salary*(per/100);
        newSalary = salary + addOn;
    }

    public void displayDetails(){
        System.out.println("EmpID:"+empId);
        System.out.println("Name: "+name);
        System.out.println("New Salary: "+ newSalary);
    }
}
