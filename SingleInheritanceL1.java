/*
LEVEL 1 (Single Inheritance)
Question: Person → Student
Create class Person:
-name
-age

Create class Student extends Person:
-rollNo

--Create constructor in both
--Display all details

Expected Output:
Name: Sneha
Age: 21
Roll No: 101 
*/

public class SingleInheritanceL1 {
    public static void main(String[] args) {
        Person p1 = new Person("neha", 20);
        p1.display();

        Student st1 = new Student("Sneha", 22, 192);
        st1.display();

        //Student s12 = new Person("per",9);//wrong okk
        Person p2 = new Student("hena", 30, 60);//right can 
        p2.display();

    }
}

class Person{
    String name;
    int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    void display(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
     }
}

class Student extends Person{
     int rollNo;

     Student(String name, int age, int rollNo){
        super(name, age);    
        this.rollNo = rollNo;
     }

     void display(){
        super.display();
        System.out.println("Roll No: " + rollNo);
     }

}
