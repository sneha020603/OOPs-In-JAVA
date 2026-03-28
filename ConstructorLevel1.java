/*
LEVEL 1 (Foundation)
Question 1: Student Details
Create a class Student with:
int id
String name

-Use constructor to initialize values
-Create a method display() to print details

Input (hardcode allowed):
1 Sneha

Output:
Id: 1
Name: Sneha
*/

import java.util.Scanner;


public class ConstructorLevel1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id= sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();

        Student st1 = new Student(id,name);
        st1.display();

        sc.close();
    }
    
}

class Student{
    int id;
    String name;

    Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    void display(){
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
    }
}
