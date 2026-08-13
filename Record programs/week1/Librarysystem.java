class Book {

    private int bookId;
    private String bookName;
    private String author;
    private double price;

    // const
    Book() {
        bookId = 0;
        bookName = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    //const with param
    Book(int id, String name, String auth, double pr) {
        bookId = id;
        bookName = name;
        author = auth;
        price = pr;
    }

    // getters & setters for Encapsulation
    public int getBookId() { return bookId; }
    public void setBookId(int id) { bookId = id; }

    public String getBookName() { return bookName; }
    public void setBookName(String name) { bookName = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String auth) { author = auth; }

    public double getPrice() { return price; }
    public void setPrice(double pr) { price = pr; }

    public void displayDetails() {
        System.out.println(bookId + " | " + bookName + " | " + author + " | " + price);
    }
}

// inheritance super:person sub:student and faculty

class Person {

    String name;
    int age;

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {

    String course;

    @Override
    void display() {
        super.display();
        System.out.println("Course: " + course);
    }
}

class Faculty extends Person {

    String department;

    @Override
    void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

//polymorph

class AreaCalculator {

    double area(double radius) {
        return Math.PI * radius * radius;
    }

    double area(double length, double breadth) {
        return length * breadth;
    }

    double area(double base, double height, boolean triangle) {
        return 0.5 * base * height;
    }
}

class Vehicle {

    void display() {
        System.out.println("This is a vehicle.");
    }
}

class Car extends Vehicle {

    @Override
    void display() {
        System.out.println("This is a Car.");
    }
}

class Bike extends Vehicle {

    @Override
    void display() {
        System.out.println("This is a Bike.");
    }
}

// abstraction

abstract class Shape {

    abstract void draw();
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

interface Printable {

    void print();
}

class Report implements Printable {

    @Override
    public void print() {
        System.out.println("Printing Report...");
    }
}

public class Librarysystem {

    public static void main(String[] args) {

        System.out.println(" Book Details :");

        Book b1 = new Book();
        Book b2 = new Book(235, "Java programming practices", "Santosh Kumar P", 499.99);

        b1.displayDetails();
        b2.displayDetails();

        System.out.println("\n Inheritance:");

        Student s = new Student();

        s.name = "Haarika";
        s.age = 20;
        s.course = "Computer Science";

        s.display();

        Faculty f = new Faculty();

        f.name = "Dr. Rao";
        f.age = 45;
        f.department = "Engineering";

        f.display();

        System.out.println("\nPolymorphism:");

        AreaCalculator ac = new AreaCalculator();

        System.out.println("Circle Area: " + ac.area(5));
        System.out.println("Rectangle Area: " + ac.area(4, 6));
        System.out.println("Triangle Area: " + ac.area(3, 7, true));

        Vehicle v = new Vehicle();
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        v.display();
        car.display();
        bike.display();

        System.out.println("\n Abstraction & Interfaces");

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();

        Report report = new Report();
        report.print();
    }
}