/*
Create a class Institution with below attributes:  
institutionId - int 
InstitutionName - String 
no0fStudentsPlaced - int 
no0fStudentsCleared- int 
location - String 
grade - String  

Write getters, setters for the above attributes. 
Create constructor which takes parameter in the above sequence except grade.  Create class Solution with main method. 

Implement two static methods - 
findNumClearancedByLoc 
updateInstitutionGrade

findNumClearancedByLoc method: This method will take two input parameters - array of Institution objects and string parameter location. 
                               The method will return the sum of the noOfStudentsCleared attribute from institution objects for the location passed as parameter. 
                               If no institution with the given location is present in the array of institution objects, 
                               then the method should return 0.  
                               
updateInstitutionGrade method: This method will take a String parameter institutionName, along with the array of Institution objects. 
                               The method will return the institution object, if the input String parameter matches with the institutionName attribute of the institution object.

                    Before returning the object, the grade should be arrived based on the rating calculation mentioned below. 
                    This grade value should be assigned to the object. If any of the above conditions are not met, 
                    then the method should return null.
            
            The grade attribute should be calculated as follows:  rating=(no0fStudentsPlaced * 100)/no0fStudentsCleared 
                                                                  If the rating gt= 80 , then grade should be 'A'. 
                                                                  Else, then grade should be 'B'  
                                                                  
            Note: No institution object would have the same value for institutionName attribute. 
                  All institution object would have the noOfStudentsPlaced value lesser than noOfStudentsCleared value. 
                  All the searches should be case insensitive.  
                  The above mentioned static methods should be called from the main method. 
                
For findNumClearancedByLoc method - The main method should print the noOfClearance as it is, 
                                    if the returned value is greater than 0, 
                                    or it should print "There are no cleared students in this particular location".  
                                    
For updateInstitutionGrade method - The main method should print the institutionName and grade of the returned Institution object. 
                                    The instituationName and grade should be concetinated with :: while printing.        

                    eg :- TCS :: A, where TCS is the institution name and A is the grade. 
                    If the returned value is null then it should print "No Institute is available with the specified name".  
                    
Before calling these static methods in main, use Scanner object to read the values of four Phone objects referring attributes in the above mentioned attribute sequence (except grade attribute). 
Next, read the value for location and institutionName.  

Input: A  
111
Amrita
5000
10000
Chennai
222
Karunya
16000
20000
Coimbatore
333
AppleTech
10000
12000
Chennai
444
Aruna
6000
10000
Vellore
Chennai
Karunya

Output : 
22000
Karunya:: A
*/

import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institution[] institutions = new Institution[4];

        for (int i = 0; i < 4; i++) {
            int institutionId = sc.nextInt();
            sc.nextLine(); // Consume newline
            String institutionName = sc.nextLine();
            int noOfStudentsPlaced = sc.nextInt();
            int noOfStudentsCleared = sc.nextInt();
            sc.nextLine(); // Consume newline
            String location = sc.nextLine();
            institutions[i] = new Institution(institutionId, institutionName, noOfStudentsPlaced, noOfStudentsCleared, location);
        }

        String inputLocation = sc.nextLine();
        String inputInstitutionName = sc.nextLine();

        int totalCleared = findNumClearancedByLoc(institutions, inputLocation);
        if (totalCleared > 0) {
            System.out.println(totalCleared);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }

        Institution institution = updateInstitutionGrade(institutions, inputInstitutionName);
        if (institution != null) {  
            System.out.println(institution.getInstitutionName() + ":: " + institution.getGrade());
        } else {
            System.out.println("No Institute is available with the specified name");
        }   
 
        sc.close();
    }

    private static Institution updateInstitutionGrade(Institution[] institutions, String inputInstitutionName) {
        
        for(Institution is:institutions){
            if(is.getInstitutionName().equals(inputInstitutionName)){
               int  rating = (is.getNoOfStudentsPlaced() * 100)/is.getNoOfStudentsCleared();

               if(rating >= 80){
                  is.setGrade("A");
               }else{
                is.setGrade("B");
               }

               return is;
            }
        }

        return null;
    }

    private static int findNumClearancedByLoc(Institution[] institutions, String inputLocation) {
        int total =0;

        for(Institution is:institutions){
            if(is.getLocation().equals(inputLocation)){
                total += is.getNoOfStudentsCleared();
            }
        }
        return total;
    }
}

class Institution{
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getNoOfStudentsPlaced() {
        return noOfStudentsPlaced;
    }

    public void setNoOfStudentsPlaced(int noOfStudentsPlaced) {
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }

    public int getNoOfStudentsCleared() {
        return noOfStudentsCleared;
    }

    public void setNoOfStudentsCleared(int noOfStudentsCleared) {
        this.noOfStudentsCleared = noOfStudentsCleared;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
