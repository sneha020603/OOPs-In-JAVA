/*
Q.4 Create a class AutonomousCar with the below attributes:  
carld- int 
brand - String  
noOfTestsConducted- int  
noOfTestsPassed-int 
environment - String  

Write getters, setters for the above attributes, Create constructor which takes parameter in the above sequence except grade.  
Create class Solution with main method. 

Implement two static methods - 
findTestPassedByEnv and updateCarGrade in Solution class.  

findTestPassedByEnv method: This method will take two input parameters -array of AutonomousCar objects 
                            and string parameter environment. 
                            The method will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter.

                            If no autonomousCar with the given environment is present in the array of AutonomousCar objects, 
                            then the method should return 0.

updateCarGrade method:  This method will take a String parameter brand, 
                        along with the array of AutonomousCar objects. 
                        The method will return the autonomousCar object, 
                        if the input String parameter matches with the brand attribute of the autonomousCar object.
                        
                        Before returning the object, the grade should be derived based on the rating calculation mentioned below. 
                        This grade value should be assigned to the object. 
                        If any of the above conditions are not met, then the method should return null.  
                        
        The grade attribute should be calculated as follows: rating.(noOfTestsPassed * 100)/noOfTestsConducted  
        If the rating > = 80 then grade should be 'A1', otherwise the grade should be ʻB2'.  
        
The above mentioned static methods should be called from the main method. 
For findTestPassedByEnv method - The main method should print the totalTestPassed as it is, 
                                 if the returned value is greater than 0, 
                                 or it should print "There are no tests passed in this particular environment". 
                                 
For updateCarGrade method - The main method should print the brand and grade of the returned autonomousCar object.
                            The brand and grade should be concatinated with :: while printing. 
                            eg :- Tesla :: A1, where Tesla is the brand and Al is the grade. 
                            If the returned value is null then it should print "No Car is available with the specified brand". 

Before calling these static methods in main, 
use Scanner object to read the values of four autonomousCar objects referring attributes in 
the above mentioned attribute sequence (except grade attribute). 
Next, read the value for environment and brand.

Input:  
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output:
1900
Mercedez :: B2
*/

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[4];
        for(int i=0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String brand = sc.nextLine();
            int conducted = sc.nextInt();
            int passed = sc.nextInt();
            sc.nextLine();
            String env = sc.nextLine();

            cars[i] = new AutonomousCar(id, brand, conducted, passed, env);
        }
        String envInput = sc.nextLine();
        String brandInput = sc.nextLine();

        int totalTestPassed = findTestPassedByEnv(cars, envInput);
        if(totalTestPassed > 0){
            System.out.println(totalTestPassed);    
        }else{
            System.out.println("There are no tests passed in this particular environment");
        }

        AutonomousCar updatedCar = updateCarGrade(brandInput, cars);
        if(updatedCar != null){
            System.out.println(updatedCar.getBrand() + " :: " + updatedCar.getGrade());
        }else{
            System.out.println("No Car is available with the specified brand");
        }

        sc.close();
    }

    private static AutonomousCar updateCarGrade(String brandInput, AutonomousCar[] cars) {
        
        for(AutonomousCar c : cars){
            if(c.getBrand().equals(brandInput)){

                int rating = (c.getNoOfTestsPassed() * 100) / c.getNoOfTestsConducted();

                if (rating >= 80) {
                    c.setGrade("A1");
                } else {
                    c.setGrade("B2");  
                }  

                 return c; 
            }
        }

        return null;
    }

    private static int findTestPassedByEnv(AutonomousCar[] cars, String envInput) {
        int sum=0;
        for(AutonomousCar c : cars){
            if(c.getEnvironment().equals(envInput)){
                sum += c.getNoOfTestsPassed();
            }
        }
        return sum;
    }
}

class AutonomousCar{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;

    public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
