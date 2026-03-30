/*
LEVEL 3 
Question: Payment System

Create base class Payment
pay(double amount)

Create child classes:
-CreditCard
adds 2% charge

-UPI
no charge

--Requirements:
Use overriding
Use parent reference
Different outputs

--Expected Output:
Paid using Credit Card: 1020
Paid using UPI: 1000
*/

public class FinalPolymorphismL3 {
    public static void main(String[] args) {
        Payment p1 = new CreditCard();
        p1.pay(1000);

        Payment p2 = new UPI();
        p2.pay(1000);
    }
}

class Payment{

    void pay(double amount){
        System.out.println("Payment:"+amount);
    }
}

class CreditCard extends Payment{
    double finalPay;

    @Override
    void pay(double amount){
        finalPay = amount + amount*0.02;
        System.out.println("Paid using Credit Card: "+finalPay);
    }

}

class UPI extends Payment{ 
    @Override
    void pay(double amount){
        System.out.println("Paid using UPI: "+amount);
    }
}
