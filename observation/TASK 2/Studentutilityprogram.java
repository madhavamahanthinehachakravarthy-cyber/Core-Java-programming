import java.util.Scanner;

public class Studentutilityprogram {

    // ---------- Methods ----------
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static boolean prime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int maximum(int a, int b) {
        return (a > b) ? a : b;
    }

    public static double areaCircle(double r) {
        return 3.14 * r * r;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            
            do {
                
                System.out.println("\n===== STUDENT UTILITY PROGRAM =====");
                System.out.println("1. Student Information");
                System.out.println("2. Even or Odd");
                System.out.println("3. Largest of Three Numbers");
                System.out.println("4. Grade using Percentage");
                System.out.println("5. Day of Week");
                System.out.println("6. Multiplication Table");
                System.out.println("7. Display 1 to N");
                System.out.println("8. Sum of First N Natural Numbers");
                System.out.println("9. Fibonacci Series");
                System.out.println("10. Factorial");
                System.out.println("11. Prime Number");
                System.out.println("12. Maximum of Two Numbers");
                System.out.println("13. Area of Circle");
                System.out.println("14. Exit");
                
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    
                    case 1 -> {
                        sc.nextLine();
                        
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        
                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        
                        System.out.print("Enter Marks of Subject1: ");
                        int m1 = sc.nextInt();
                        
                        System.out.print("Enter Marks of Subject2: ");
                        int m2 = sc.nextInt();
                        
                        System.out.print("Enter Marks of Subject3: ");
                        int m3 = sc.nextInt();
                        int total = m1 + m2 + m3;
                        double percentage = total / 3.0;
                        
                        System.out.println("Name : " + name);
                        System.out.println("Roll No : " + roll);
                        System.out.println("Total : " + total);
                        System.out.println("Percentage : " + percentage);
                    }
                        
                    case 2 -> {
                        System.out.print("Enter Number: ");
                        int n = sc.nextInt();
                        
                        if (n % 2 == 0)
                            System.out.println("Even Number");
                        else
                            System.out.println("Odd Number");
                    }
                        
                    case 3 -> {
                        System.out.print("Enter Three Numbers: ");
                        int a = sc.nextInt();
                        int b = sc.nextInt();
                        int c = sc.nextInt();
                        if (a >= b && a >= c)
                            System.out.println("Largest = " + a);
                        else if (b >= c)
                            System.out.println("Largest = " + b);
                        else
                            System.out.println("Largest = " + c);
                    }
                        
                    case 4 -> {
                        System.out.print("Enter Percentage: ");
                        double per = sc.nextDouble();
                        
                        if (per >= 90)
                            System.out.println("Grade A");
                        else if (per >= 75)
                            System.out.println("Grade B");
                        else if (per >= 60)
                            System.out.println("Grade C");
                        else if (per >= 40)
                            System.out.println("Grade D");
                        else
                            System.out.println("Fail");
                    }
                        
                    case 5 -> {
                        System.out.print("Enter Day Number (1-7): ");
                        int day = sc.nextInt();
                        
                        switch (day) {
                            
                            case 1 -> System.out.println("Monday");
                            case 2 -> System.out.println("Tuesday");
                            case 3 -> System.out.println("Wednesday");
                            case 4 -> System.out.println("Thursday");
                            case 5 -> System.out.println("Friday");
                            case 6 -> System.out.println("Saturday");
                            case 7 -> System.out.println("Sunday");
                            default -> System.out.println("Invalid Day");
                        }
                    }
                        
                    case 6 -> {
                        System.out.print("Enter Number: ");
                        int num = sc.nextInt();
                        
                        for (int i = 1; i <= 10; i++) {
                            System.out.println(num + " x " + i + " = " + (num * i));
                        }
                    }
                        
                    case 7 -> {
                        System.out.print("Enter N: ");
                        int limit = sc.nextInt();
                        
                        for (int i = 1; i <= limit; i++) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                        
                    case 8 -> {
                        System.out.print("Enter N: ");
                        int x = sc.nextInt();
                        int sum = 0;
                        
                        for (int i = 1; i <= x; i++)
                            sum += i;
                        
                        System.out.println("Sum = " + sum);
                    }
                        
                    case 9 -> {
                        System.out.print("Enter Number of Terms: ");
                        int terms = sc.nextInt();
                        int first = 0, second = 1;
                        System.out.print(first + " " + second + " ");
                        for (int i = 3; i <= terms; i++) {
                            int next = first + second;
                            System.out.print(next + " ");
                            first = second;
                            second = next;
                        }
                        System.out.println();
                    }
                        
                    case 10 -> {
                        System.out.print("Enter Number: ");
                        int fact = sc.nextInt();
                        System.out.println("Factorial = " + factorial(fact));
                    }
                        
                    case 11 -> {
                        System.out.print("Enter Number: ");
                        int p = sc.nextInt();
                        
                        if (prime(p))
                            System.out.println("Prime Number");
                        else
                            System.out.println("Not Prime");
                    }
                        
                    case 12 -> {
                        System.out.print("Enter Two Numbers: ");
                        int n1 = sc.nextInt();
                        int n2 = sc.nextInt();
                        
                        System.out.println("Maximum = " + maximum(n1, n2));
                    }
                        
                    case 13 -> {
                        System.out.print("Enter Radius: ");
                        double r = sc.nextDouble();
                        
                        System.out.println("Area = " + areaCircle(r));
                    }
                    case 14 -> System.out.println("Thank You");
                        
                    default -> System.out.println("Invalid Choice");
                }
                
            } while (choice != 14);
        }
    }
}