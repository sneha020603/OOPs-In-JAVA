/*
LEVEL 2 (Basic method Overriding Polymorphism)
Question: Animal Sounds

Create class Animal
makeSound()

Create:
Dog → "Bark"
Cat → "Meow"

Use:
Animal a = new Dog();
a.makeSound();
*/

public class MethodOverridingL1 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();

        Dog d1 =  new Dog();
        d1.makeSound();
        Animal d2 =  new Dog();
        d2.makeSound();

        Cat c1 = new Cat();
        c1.makeSound();
        Animal c2 = new Cat();
        c2.makeSound();
    }
}

class Animal{
    
    void makeSound(){
        System.out.println("Animal can make sound!");
    }
}

class Dog extends Animal{

    @Override
    void makeSound(){
        System.out.println("Bark");
    }
}

class Cat extends Animal{

    @Override
    void makeSound(){
        System.out.println("Meow");
    }
}

