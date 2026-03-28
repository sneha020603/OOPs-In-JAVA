/* 
Concept - Static Members Difficulty Level 2
Create a class Employee with below attributes:

id - int
name - String
designation - String
ssnNo - int
age - int
salary - double
ssnNoCounter - int which is a static field and initialize to 0

Make all the attributes private.Create corresponding getters and setters.

Create a constructor which takes all parameters except the static member and the attribute ssnNo in the above sequence.
The constructor should set the value of attributes as parameter values inside the constructor.Increment the value of the static member by 1 inside the constructor and assign to the attribute ssnNo

Test from the main method by creating  5 objects of the Employee class and print the ssnNoCounter value after creation of each object
Refer below sample main method and test the output:

public class EmployeeDemo {
            public static void main(String args[]) {
                Employee employee1 = new Employee(28, "bawczld", "rpiphga", 24, 218.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee2 = new Employee(28, "sjfyirr", "wsexoca", 70, 493.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee3 = new Employee(69, "xxtvzeg", "vhrnoxk", 68, 388.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee4 = new Employee(27, "luydzvs", "husrfkh", 95, 887.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee5 = new Employee(33, "ozduycg", "wjxzjzz", 67, 552.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());
            }
}

Output 
Valueof ssnNoCounter:1
Value of ssnNoCounter:2
Value of ssnNoCounter:3
Value of ssnNoCounter:4
Value of ssnNoCounter:5
*/

class Employee {
    private int id;
    private String name;
    private String designation;
    private int ssnNo;
    private int age;
    private double salary;
    private static int ssnNoCounter = 0;

    public Employee(int id, String name, String designation, int age, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.age = age;
        this.salary = salary;
        ssnNoCounter++;
        this.ssnNo = ssnNoCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSsnNo() {
        return ssnNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getSsnNoCounter() {
        return ssnNoCounter;
    }

}

public class TCSPractice1 {
            @SuppressWarnings("unused")
            public static void main(String args[]) {
                Employee employee1 = new Employee(28, "bawczld", "rpiphga", 24, 218.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee2 = new Employee(28, "sjfyirr", "wsexoca", 70, 493.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee3 = new Employee(69, "xxtvzeg", "vhrnoxk", 68, 388.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee4 = new Employee(27, "luydzvs", "husrfkh", 95, 887.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                Employee employee5 = new Employee(33, "ozduycg", "wjxzjzz", 67, 552.0);
                System.out.println("Value of ssnNoCounter : " + Employee.getSsnNoCounter());

                
            }
}