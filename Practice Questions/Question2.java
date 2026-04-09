/*
Q.2 Create class Movie with below attributes: 
movieName - String 
company - String  
genre - String 
budget - int 

Create class Solution and implement static method "getMovieByGenre" in the Solution class. 
This method will take array of Movie objects and a searchGenre String as parameters. 
And will return another array of Movie objects where the searchGenre String matches with the original array of Movie object's genre attribute (case insensitive search). 

Write necessary getters and setters. Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the attributes in above sequence along with a String searchGenre. 
Then call the "getMovieByGenre" method and write logic in main method to print "High Budget Movie" if the movie budget attribute is greater than 80000000 else print "Low Budget Movie".

Input:- 
aa̱a̱
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output:-  
High Budget Movie 
High Budget Movie
*/

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[4];
        
        for(int i=0;i<4;i++){
            String name = sc.nextLine();
            String comp = sc.nextLine();
            String genre = sc.nextLine();
            int budget = sc.nextInt();
            sc.nextLine();

            movies[i] = new Movie(name, comp, genre, budget);
        }

        String value = sc.nextLine();

        Movie[] result = getMovieByGenre(movies,value);
       if(result.length > 0){
        for(Movie m:result){
            if(m.getBudget() > 80000000){
                System.out.println("High Budget Movie");
            }else{
                System.out.println("Low Budget Movie");
            }
        }
    }else{
        System.out.println("No Movie found");

    }

    sc.close();
        
    }

    public static Movie[] getMovieByGenre(Movie[] movies, String value) {
        int count=0;
        for(Movie m:movies){
            if(m.getGenre().equalsIgnoreCase(value)){
                count++;
            }
        }

        if (count == 0) return new Movie[0];

        Movie[] resMovie = new Movie[count];
        int index=0;
        for(Movie m:movies){
            if(m.getGenre().equalsIgnoreCase(value)){
                resMovie[index++] = m;
            }
        }

        return resMovie;
    }
}

class Movie {
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    public Movie(String movieName, String company, String genre, int budget) {
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
