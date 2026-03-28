/*
LEVEL 3 
Question 3: Bank Account System

Create class BankAccount with:
accountNumber
accountHolderName
balance
accountType ("Saving" / "Current")

Requirements:
Constructor to initialize values

Method:
calculateInterest()

Rules:
Saving → 4% interest
Current → 2% interest
If Current balance < 5000 → print:
Insufficient balance

Method:
display()

Input (hardcode or scanner):
Account 1 → Saving → 10000
Account 2 → Current → 3000

Expected Output:
Account Number: 1
Name: Sneha
Balance: 10400
Type: Saving

--Insufficient balance

Account Number: 2
Name: Rahul
Balance: 3000
Type: Current
*/
import java.util.*;

public class ConstructorLevel3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account no.: ");
        int accNum = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter accountHolder name:");
        String accHolder = sc.nextLine();
        System.out.println("Enter account balance name:");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the account Type(\"Saving\" / \"Current\"):");
        String accType = sc.nextLine();

        BankAccount acc1 = new BankAccount(accNum, accHolder, balance, accType);
        acc1.calculateInterest();
        acc1.display();

        sc.close();
    }
}

class BankAccount{
    int accNum;
    String accHolder;
    double balance;
    String accType;
    double newBalane;

    BankAccount(int accNum,String accHolder,double balance,String accType){
        this.accNum = accNum;
        this.accHolder = accHolder;
        this.balance = balance;
        this.accType = accType;
    }

    public void calculateInterest(){
        if(accType.equalsIgnoreCase("Current")){
            if(balance < 5000){
                System.out.println("Insufficient balance.");
            }else{
                newBalane = balance + balance * 2.0 / 100;
            }
        }else{
            newBalane = balance + balance * 4.0 / 100;
        }
    }

    public void display(){
        System.out.println("Account no.:"+accNum);
        System.out.println("Name: "+accHolder);
        System.out.println("Updated Balance: "+ newBalane);
        System.out.println("Account type:"+ accType);
    }
}
