/*
LEVEL 3 
Question: Shape System (Overriding)

Create base class Shape:
-area()

Create 2 child classes:

Circle
-radius
area = π * r * r

Rectangle
-length, breadth
area = l * b

Requirements:
--Use method overriding
--Same method name area()

Different outputs based on object
Expected Output:
Circle Area: 78.5
Rectangle Area: 20
*/

public class InheritanceShapeL3 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        c1.area();

        Rectangle r1 = new Rectangle(4, 5);
        r1.area();

        Shape s1 = new Circle(3);
        s1.area();

        Shape s2 = new Rectangle(2, 3);
        s2.area();
        
    }
}

class Shape{
    void area(){
        System.out.println("Area of shape");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    void area(){
        double area = Math.PI * radius * radius;
        System.out.println("Circle Area: " + area);
    }
}

class Rectangle extends Shape{
    double length, breadth;

    Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void area(){
        double area = length * breadth;
        System.out.println("Rectangle Area: " + area);
    }
}
