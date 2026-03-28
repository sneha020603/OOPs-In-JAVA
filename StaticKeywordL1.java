/*
LEVEL 2 (static counter)
Question:
Create class Student:
-static int counter
-int studentId
-String name

--Auto-generate studentId using static counter

Output:
ID: 1 Name: Sneha
ID: 2 Name: Rahul
*/

import java.util.Scanner;

public class StaticKeywordL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String stname1 = sc.nextLine();

        Student st1 = new Student(stname1);
        st1.display();

        sc.close();
    }
}

class Student{
    int stID;
    String stName;
    static int counter =0;

    Student(String  stName){
        this.stName =  stName;
        counter++;
        this.stID = counter;
    }

    void display(){
        System.out.println("ID: "+stID+" "+"Name: "+stName);
    }
}
