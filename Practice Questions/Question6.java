/*
Create a class TravelAgencies with below attributes:   
regNo - int 
agencyName - String 
packageType - String 
price - int 
flightFacility - boolean  

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence.  
Create class Solution with main method. 

Implement two static methods(and in Solution class) - 
-findAgencyWithHighestPackagePrice 
-agencyDetailsforGivenIdAndType  

findAgencyWithHighestPackagePrice method: This method will take array of TravelAgencies objects as an input parameter 
                                          and return the highest package price from the given array of objects.  
                                
agencyDetailsForGivenldAndType method:  This method will take three input parameters - 
                                        array of TravelAgencies objects, int parameter regNo and String parameter packageType. 
                                        The method will return the TravelAgencies object based on below conditions. 
                                        
                         FlightFacility should be available. 
                         The input parameters(regNo and packageType) should matched with the regNo and packageType of TravelAgencies object. 
                         If any of the above conditions are not met, then the method should return null. 
                         
                         Note : Same Travel agency can have more than one package type. 
                                Travel agency and package type combination is unique. 
                                All the searches should be case in sensitive.  
                                
For findAgencyWithHighestPackagePrice method - The main method should print the highestPackagePrice as it is. 
For agencyDetailsForGivenldAndType method - The main method should print the AgencyName and price of the returned object.
                                            The AgencyName and price should be concatinated with : while printing.
                                            
Input  
123
A2Z Agency
Platinum
50000
true
345
SSS Agency
Gold
30000
false
987
Cox and Kings
Diamond
40000
true
888
Global Tours
Silver
20000
false
987
Diamond

Output  
50000 
Cox and Kings:40000
*/

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=4;
        TravelAgencies[] agencies = new TravelAgencies[n];

        for(int i=0;i<n;i++){
            int regNo = sc.nextInt();
            sc.nextLine();
            String agencyName = sc.nextLine();
            String packageType = sc.nextLine();
            int price = sc.nextInt();
            boolean flightFacility = sc.nextBoolean();

            agencies[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility);
        }

        int findRegNo = sc.nextInt();
        sc.nextLine();
        String findPackageType = sc.nextLine();

        int highestPrice = findAgencyWithHighestPackagePrice(agencies);
        System.out.println(highestPrice);

        TravelAgencies find = agencyDetailsForGivenldAndType(agencies,findRegNo,findPackageType);
        if(find != null){
            System.out.println(find.getAgencyName()+":"+find.getPrice());
        }else{
            System.out.println("No Travel Agency found");
        }

        sc.close();
    }

    private static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies) {
        TravelAgencies tg = null;

        for(TravelAgencies a:agencies){
            if(tg == null || tg.getPrice() < a.getPrice()){
                tg = a;
            }
        }

        return tg.getPrice();
    }

    private static TravelAgencies agencyDetailsForGivenldAndType(TravelAgencies[] agencies, int findRegNo,
            String findPackageType) {
         
         for(TravelAgencies tg:agencies){
            if(tg.getRegNo() == findRegNo && tg.getPackageType().equalsIgnoreCase(findPackageType) && tg.isFlightFacility()){
                return tg;
            }
         }
         
         return null;
    }
}

class TravelAgencies{
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;

    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}
