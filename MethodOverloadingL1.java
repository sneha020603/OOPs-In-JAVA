/*
LEVEL 1 (Method Overloading)
Question: Calculator

Create class Calculator

Methods:
add(int a, int b)
add(int a, int b, int c)
add(double a, double b)

Print result for each
*/

public class MethodOverloadingL1 {
    public static void main(String[] args) {

        Calculator cal = new Calculator();
        int ans1 = cal.add(10, 30);
        int ans2 = cal.add(90, 80, 67);
        double ans3 = cal.add(ans1, ans2);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        
    }
}

class Calculator{
    int add(int a,int b){
        int sum = a + b;
        return sum;
    }

    int add(int a,int b,int c){
        int sum = a+b+c;
        return sum;
    }

    double add(double a,double b){
        double sum = a + b;
        return sum;
    }
}


