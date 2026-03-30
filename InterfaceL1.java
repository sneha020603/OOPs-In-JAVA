/*
LEVEL 2 (Interface)
Question: Payment System

Create interface Payment
pay(double amount)

Create:
CreditCard
UPI

--Implement interface
*/

public class InterfaceL1 {
    public static void main(String[] args) {
        CreditCard c = new CreditCard();
        c.pay(1000);

        UPI u = new UPI();
        u.pay(1000);
    }
}

interface Payment{
    void pay(double amount);
}

class CreditCard implements Payment{

    public void pay(double amount){
        double finalPay = amount + amount*0.02;
        System.out.println("Paid using Credit Card: "+finalPay);
    }

}

class UPI implements Payment{ 

    public void pay(double amount){
        System.out.println("Paid using UPI: "+amount);
    }
}

