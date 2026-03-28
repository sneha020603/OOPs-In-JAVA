/*
LEVEL 1 (this keyword)
Question:
Create class Car:
-brand
-price

--Use constructor
--Use this keyword
--Display details
*/
import java.util.*;

public class ThisKeywordL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Brand name: ");
        String brand = sc.nextLine();
        System.out.println("Enter the price: ");
        double price = sc.nextDouble();

        Car car1 = new Car(brand, price);
        car1.display();
        
        sc.close();
    }
}

class Car{
    String brand;
    double price;

    Car(String brand, double price){
        this.brand = brand;
        this.price = price;
    }

    void display(){
        System.out.println("Brand: "+brand);
        System.out.println("Price: "+price);
    }
}
