/*
Statement
ABC Bank plans to automate it's account related operations, Bank has functionality to
open account, there are two types of accounts, such as, saving account and current
account. Bank takes the request from the user to open the Bank account and it maintains
the details, such as, accountNumber, accountHolderName, balance and type of account.

Identify the entities and create classes, create at-least two objects of identified class and
display the details using constructors. Access the data only through Getters and Setters.
*/

import java.util.*;

class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String type;

    // Default Constructor
    Account() {
        accountNumber = 0;
        accountHolderName = "";
        balance = 0;
        type = "";
    }

    // Parameterized Constructor
    Account(int accountNumber, String accountHolderName, double balance, String type) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.type = type;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

public class GettersAndSetters {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Object 1 - Parameterized Constructor
        Account acc1 = new Account(1001, "Pranjali", 4000, "Current");

        System.out.println("Account Details (Constructor):");
        System.out.println("Account Number: " + acc1.getAccountNumber());
        System.out.println("Name: " + acc1.getAccountHolderName());
        System.out.println("Balance: " + acc1.getBalance());
        System.out.println("Type: " + acc1.getType());

        System.out.println("\n--------------------------------");

        // Object 2 - User Input
        Account acc2 = new Account();

        System.out.print("Enter Account Number: ");
        acc2.setAccountNumber(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Name: ");
        acc2.setAccountHolderName(sc.nextLine());

        System.out.print("Enter Balance: ");
        acc2.setBalance(sc.nextDouble());
        sc.nextLine();

        System.out.print("Enter Type (Saving/Current): ");
        acc2.setType(sc.nextLine());

        System.out.println("\nAccount Details (User Input):");
        System.out.println("Account Number: " + acc2.getAccountNumber());
        System.out.println("Name: " + acc2.getAccountHolderName());
        System.out.println("Balance: " + acc2.getBalance());
        System.out.println("Type: " + acc2.getType());

        sc.close();
    }
}