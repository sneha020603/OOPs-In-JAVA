/*
LEVEL 1 (Abstract Class)
Question: Shape System

Create abstract class Shape
abstract void area();

Create:
Circle
Rectangle

 -Override area()
*/

public class AbstractClassL1 {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.5);
        c1.area();

        Rectangle r1 =  new Rectangle(25, 10);
        r1.area();
    }
}

abstract class Shape{
    abstract void area();
}

class Circle extends Shape{
    double radius;
    double pie = Math.PI;

    Circle(double radius){
        this.radius = radius;
    }

    void area(){
        double area = pie*radius*radius;
        System.out.println("Area od a Circle: "+ area);
    }
}

class Rectangle extends Shape{
    int len;
    int bre;

    Rectangle(int len,int bre){
        this.len = len;
        this.bre = bre;
    }

    void area(){
        int area = len*bre;
        System.out.println("Area od a Rectangle: "+area);
    }

}
