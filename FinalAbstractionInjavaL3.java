/*
LEVEL 3 
Question: Employee System

Create abstract class Employee:
-id
-name

Method:
-abstract double calculateSalary();

--child classes:
-FullTimeEmployee
fixed salary + bonus

-PartTimeEmployee
hours * rate

--Expected Output:
Full Time Salary: 60000
Part Time Salary: 20000
*/

public class FinalAbstractionInjavaL3 {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee(1, "Sneha", 50000, 10000);
        Employee e2 = new PartTimeEmployee(2, "Rahul", 100, 200);

        System.out.println("Full Time Salary: " + e1.calculateSalary());
        System.out.println("Part Time Salary: " + e2.calculateSalary());
    }
}

abstract class Employee {
    int id;
    String name;

    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    abstract double calculateSalary();
}

// Full-time employee
class FullTimeEmployee extends Employee {
    double salary;
    double bonus;

    FullTimeEmployee(int id, String name, double salary, double bonus){
        super(id, name);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary(){
        return salary + bonus;
    }
}

// Part-time employee
class PartTimeEmployee extends Employee {
    int hours;
    double rate;

    PartTimeEmployee(int id, String name, int hours, double rate){
        super(id, name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculateSalary(){
        return hours * rate;
    }
}

