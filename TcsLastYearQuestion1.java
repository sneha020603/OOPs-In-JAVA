/*
Write a program to:

Read 5 integer values into an array
Read two integers: limit1 and limit2
Find the average of all values in the array that are:
greater than limit1
less than limit2

Return the average as an integer.

If no values satisfy the condition, return 0.
*/


import java.util.Scanner;

public class TcsLastYearQuestion1 {
    public static void main(String str[]) 
    { 
        Scanner sc = new Scanner(System.in); 
        int[] arr = new int[5]; 
        for(int i = 0; i < 5; i++) 
            { 
                arr[i] = sc.nextInt(); 
            } 
            
        int limit1 = sc.nextInt(); 
        int limit2 = sc.nextInt(); 
        int ans = getAns(arr, limit1, limit2); 
        System.out.println(ans);
        
        sc.close();
    } 
    
    public static int getAns(int[] arr, int limit1, int limit2) { 
        int sum = 0; 
        int count = 0; 
        
        for(int i = 0; i < arr.length; i++) { 
            int curr = arr[i]; 
            if(curr > limit1 && curr < limit2) { 
                sum += curr; count++; 
            } 
        }
             if(count != 0) return sum / count; 
             return 0; 
            
    }
    
}
