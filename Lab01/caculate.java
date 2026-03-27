import java.util.Scanner;

public class caculate {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("The first number: ");
        double num1 = sc.nextDouble();

        System.out.print("The second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Sum: " + (num1+num2) );
        System.out.println("Difference: " + (Math.abs(num1-num2)));
        System.out.println("Product: " + (num1*num2));

        if (num2==0){
            System.out.println("Error: Do not divide to 0");
        }else {
            System.out.println("Quotient: " + (num1 / num2));
        }
        sc.close();
    }
}
