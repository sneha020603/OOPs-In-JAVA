/*
Create a class Student with below attributes: 
id - int 
name - String 
totmarksobt - int  

Note: The total marks obtained is considered for 4 subjects and the maximum marks that one can score in each subject is 100.  
Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.  

Create class Solution with main method  
Implement two static methods · 
findStudentWithhighestTotal and searchStudentsBypercentage in Solution class.  

findStudentWithhighestTotal Create a static method findStudentWithhighestTotal in the Solution class. 
This method will take array of Student objects as input and returns the Student's name who has scored the highest total. 
Display the student's name in UPPER case format. 

searchStudentsBypercentage Create a static method searchStudentsBypercentage in the Solution class. 
This method will take an array of Student objects and returns the sorted list of students id's(sorted in ascending order ), 
who have scored more than 70 percent or more if found, else returns null if not found.  

These methods should be called from the main method. 

Write code to perform the following tasks:  
1. Take necessary input variable and callfindStudentWithhighestTotal. 
For this method - The main method should print the Student's name with highest total(of marks) in upper case. 

2. Take necessary input variables and call searchStudentsBypercentage. 
For this method - The main method should print the Student id's (sorted in ascending order of the id's) of students 
who have scored 70 percent or more, if the returned value is not null, 
or it should print "No Student found with mentioned attribute."(without the quotes) if returned value is null.  

Refer to sample input/output below for better understanding of the format in which Student object needs to be printed in main method if returned value is not null for above methods. 
The above mentioned static methods should be called from the main method. 
Also write the code for accepting the inputs and printing the outputs. 
Don't use any static test or formatting for printing the result. 
Just invoke the method and print the result 

Note : All String comparison needs to be case in-sensitive if applicable.  
You can use/refer the below given sample input and output to verify your solution.  

Sample Input (below) description:  The 1st input taken in the main section is the number of Student objects to be added to the list of Student.
 The next set of inputs are id, name, total marks obtained for each Student object taken one after other 
 and is repeated for number of Student objects given in the first line of input. 
  Consider below sample input and output to test your code:  4

  You can use/refer the below given sample input and output to verify your solution.  Sample Input (below) description:  The 1st input taken in the main section is the number of Student objects to be added to the list of Student. 
  The next set of inputs are id, name, total marks obtained for each Student object taken one after other 
  and is repeated for number of Student objects given in the first line of input.  
  Consider below sample input and output to test your code:  
  
  Sample Input 1
5
104
Uma
223
102
Cissy
283
105
Eva
295
101
Jenny 
241
100
jisha
372 

Sample Output 1 
JISHA
100
102
105 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
      Scanner sc =  new Scanner(System.in);
      int n = sc.nextInt();
      sc.nextLine();
      Student[] students = new Student[n];

      for(int i=0;i<n;i++){
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        int marks = sc.nextInt();

        students[i] = new Student(id, name, marks);
      }

      //m-1
      String nameH = findStudentWithhighestTotal(students);
      System.out.println(nameH);

      //m-2
      int[] sorted = searchStudentsBypercentage(students);
      if(sorted.length > 0){
        for(int i:sorted){
          System.out.println(i);
        }
      }else{
        System.out.println("No student");
      }

      sc.close();
    }

    public static String findStudentWithhighestTotal(Student[] students){
      Student ans =null;
      for(Student s:students){
        if(ans == null || s.getTotmarksobt() > ans.getTotmarksobt()){
          ans = s;
        }
      }

      String ansName = ans.getName().toUpperCase();
      return ansName;
    }

    public static int[] searchStudentsBypercentage(Student[] students){
      List<Integer> ls = new ArrayList<>();

      for(Student s:students){
        int percent = (s.getTotmarksobt()*100)/400;

        if(percent >= 70){
          ls.add(s.getId());
        }
      }

      if(ls.size() == 0) return null;

      int[] ans = new int[ls.size()];
      for (int i = 0; i < ls.size(); i++) {
        ans[i] = ls.get(i);
      }
      Arrays.sort(ans);

      return ans;
    }
}

class Student{
    private int id;
    private String name;
    private int totmarksobt;

    Student(int id, String name, int totmarksobt){
      this.id = id;
      this.name = name;
      this.totmarksobt = totmarksobt;
    }

    public void setId(int id){
      this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setName(String name){
      this.name = name;
    }

    public String getName(){
      return name;
    }

    public void setTotmarksobt(int totmarksobt){
      this.totmarksobt = totmarksobt;
    }

    public int getTotmarksobt(){
      return totmarksobt;
    }

}
