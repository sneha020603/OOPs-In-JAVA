/*
LEVEL 3
Question: Account System with static
Create class Account:
-static int counter
-int accountNumber
-String name
-double balance
-static String bankName = "ABC Bank"

Requirements:
--Constructor:
-auto-generate accountNumber
-assign name & balance

Method:
-deposit(amount)
-display()

Input:
Create 2–3 objects

--Expected Output:
Account No: 1
Name: Sneha
Balance: 10000
Bank: ABC Bank

Account No: 2
Name: Rahul
Balance: 5000
Bank: ABC Bank
*/

import java.util.Scanner;

public class UseOfStaticThisKeyword {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter name:");
        String name1 = sc.nextLine();
        System.out.println("Enter ur balance: ");
        double balance1 = sc.nextDouble();

        Account acc1 = new Account(name1, balance1);
        acc1.display();
        System.out.println("Enter deposit:");
        double amount = sc.nextDouble();
        acc1.deposit(amount);
        acc1.display();

        Account acc2 = new Account("Sneha",50000);
        acc2.display();
        acc2.deposit(8000);
        acc2.display();

        sc.close();
    }
}

class Account{
    static int counter = 0;
    int accountNumber;
    String name;
    double balance;
    static String bankName = "ABC Bank";

    Account(String name, double balance){
        this.name = name;
        this.balance = balance;
        counter++;
        this.accountNumber = counter;
    }

    void deposit(double amount){
        balance += amount;
    }

    void display(){
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Bank: " + bankName);
        System.out.println("-----------------------------------");
    }


}
