/*
Q.1 create the class Course with the below Attributes.  

courseld- int  
courseName- String  
courseAdmin- String  
quiz- int  
handson -int  

The above methods should be private,write getter and setter and parametrized constructor as required.  
create class courseProgram with main method.  

implement two static methods-
--findAvgOfQuizByAdmin method: this method will take array of Course objects and a String value as input parameters.
                               This method will find out Average (as int) of Quiz questions for given Course Admin (String parametre passed).
                               This method will return Average if found.if there is no course, that matches then the method should return 0.  
                               
-- sortCourseByHandsOn method: This method will take an Array of Course Objects and int  value as input parameters. 
                               This methods should return an Array of Course objects in an ascending order of their handson which are less than the given handson(int parameter passed) value. 
                               if there is no  such course then the method should return null.  
                               
                               The above mentioned static methods should be called from  main methods.  
                               for findAvgOfQuizByAdmin method: The main method  should print the average if the returned value is not 0.
                                if the returned value is 0 then it should print "No Course found."

      for sortCourseByHandsOn method: the main method should print the name of the Course from the returned Course object Array if the returned value is not null.
      if the returned value is null then it should print "No Course found with mentioned attribute."  
      
    input1:  
    111  
    kubernetes  
    Nisha  
    40  
    10  
    321 
    cassandra  
    Roshini  
    30  
    15  
    457  
    Apache Spark 
    Nisha  
    30  
    12  
    987  
    site core  
    Tirth  
    50  
    20  
    Nisha  
    17  
    
    output1: 
     35 
     kubernetes  
     Apache Spark  
     cassandra                       
*/

import java.util.*;

class Question1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];

        for(int i=0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            String admin = sc.nextLine();
            int quiz = sc.nextInt();
            int handson = sc.nextInt();
            sc.nextLine();

            courses[i] = new Course(id, name, admin, quiz, handson);
        }

        String adminInput = sc.nextLine();
        int handsonIntput = sc.nextInt();

        int avg = findAvgOfQuizByAdmin(courses, adminInput);
        if(avg != 0){
            System.out.println(avg);
        }else{
            System.out.println("No Course found.");
        }

        Course[] result = sortCourseByHandsOn(courses, handsonIntput);
        if(result.length > 0){
            for(Course c : result){
                System.out.println(c.getCourseName());
            }
        }else{
            System.out.println("No Course found with mentioned attribute.");
        }

        sc.close();
    }

    public static int findAvgOfQuizByAdmin(Course[] courses, String courseAdmin){
        int sum =0, count=0;

        for(Course c:courses){
            if(c.getCourseAdmin().equalsIgnoreCase(courseAdmin)){
                sum += c.getQuiz();
                count++;
            }
        }

        if(count != 0){
            return sum /count ;
        }else{
            return 0;
        }
        
    }

    public static Course[] sortCourseByHandsOn(Course[] courses, int value){
        int count = 0;
        for(Course c : courses){
            if(c.getHandson() < value){
                count++;
            }
        }

        Course[] finalarr = new Course[count];
        int index =0;
        for(Course c:courses){
            if(c.getHandson() < value){
                finalarr[index++] = c;
            }
        }

        for(int i=0;i<count -1;i++){
            for(int j=i+1;j<count;j++){
                if(finalarr[i].getHandson() > finalarr[j].getHandson()){
                    Course temp = finalarr[i];
                    finalarr[i] = finalarr[j];
                    finalarr[j] = temp;
                }
            }
        }

        return finalarr;
    }

}

class Course{
    private int courseld; 
    private String courseName; 
    private String courseAdmin;  
    private int quiz; 
    private int handson;


    public Course(int courseld, String courseName, String courseAdmin, int quiz, int handson) {
        this.courseld = courseld;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }


    public int getCourseld() {
        return courseld;
    }
    public void setCourseld(int courseld) {
        this.courseld = courseld;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAdmin() {
        return courseAdmin;
    }
    public void setCourseAdmin(String courseAdmin) {
        this.courseAdmin = courseAdmin;
    }

    public int getQuiz() {
        return quiz;
    }
    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }
    
    public int getHandson() {
        return handson;
    }
    public void setHandson(int handson) {
        this.handson = handson;
    }
    
}
