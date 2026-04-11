/*
Create class Medicine with below attributes:  
medicineName - String 
batch - String 
disease - String 
price - int  

Write necessary getters and setters and constructors. 
 Create class Solution and implement 
 
 static method "getPriceByDisease" in the Solution class. 
 This method will take array of Medicine objects and a disease String as parameters. 
 And will return another sorted array of Integer objects where the disease String matches 
 with the original array of Medicine object's disease attribute (case insensitive search).   
 
Before calling "getPriceByDisease" method in the main method, read values for four Medicine objects referring the attributes 
in above sequence along with a String disease. Then call the "getPriceByDisease" method 
and print the result if the value is not null else print No Medicine found.

Input:
dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever

output:
100
200
*/

import java.util.*;

public class Question9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] medicines = new Medicine[4];

        for (int i = 0; i < 4; i++) {
            String medicineName = sc.nextLine();
            String batch = sc.nextLine();
            String disease = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine(); // Consume the newline character after reading the integer
            medicines[i] = new Medicine(medicineName, batch, disease, price);
        }

        String inputDisease = sc.nextLine();
        int[] prices = getPriceByDisease(medicines, inputDisease);

        if (prices.length > 0) {
            for (int price : prices) {
                System.out.println(price);
            }
        } else {
            System.out.println("No Medicine found");
        }
        
        sc.close();
    }

    private static int[] getPriceByDisease(Medicine[] medicines, String inputDisease) {
        int count = 0;

        for (Medicine medicine : medicines) {
            if (medicine.getDisease().equals(inputDisease)) {
                count++;
            }
        }
        int[] prices = new int[count];
        int index=0;

        for (Medicine medicine : medicines) {
            if (medicine.getDisease().equals(inputDisease)) {
                prices[index++] = medicine.getPrice();
            }
        }
        Arrays.sort(prices);
        return prices;
        
    }
}

class Medicine {
    private String medicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String medicineName, String batch, String disease, int price) {
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
