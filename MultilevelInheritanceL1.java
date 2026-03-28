/*
LEVEL 2 (Multilevel Inheritance)
Question: Person → Employee → Manager

Create class Person:
-name

Create class Employee extends Person:
-salary

Create class Manager extends Employee:
-department

Display all details

Expected Output:
Name: Sneha
Salary: 50000
Department: IT
*/

public class MultilevelInheritanceL1 {
    public static void main(String[] args) {
            Person p1 = new Person("Pranjali");
            p1.display();

            Employee e1 = new Employee("Neha", 100000);
            e1.display();

            Manager m1 = new Manager("Sneha", (double)1000000, "IT");
            m1.display();

            Person p2 = new Employee("Hena", 10000);
            p2.display();

            Employee e2 =  new Manager("Shukla", (double) 120000, "It");
            e2.display();
    }
}

class Person{
    String name;

    Person(String name){
        this.name = name;
    }

    void display(){
        System.out.println("Name: "+name);
    }
}

class Employee extends Person{
    double salary;

    Employee(String name, double salary){
        super(name);
        this.salary = salary;
    }

    void display(){
        super.display();
        System.out.println("Salary: "+salary);
    }
}

class Manager extends Employee{
    String department;

    Manager(String name,Double salary,String department){
        super(name, salary);
        this.department = department;
    }

    void display(){
        super.display();
        System.out.println("Department:"+department);
    }
}
