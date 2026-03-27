import java.sql.SQLOutput;
import java.util.Scanner;
public class solve_equation {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of variable: ");
        int num_var = sc.nextInt();

        if (num_var==1) {
            System.out.println("Degree: ");
            int deg = sc.nextInt();

            if (deg==1) {
                System.out.print("Input a in ax+b=c");
                double a = sc.nextDouble();
                System.out.print("Input b in ax+b=c");
                double b = sc.nextDouble();

                if (a == 0) {
                    System.out.println(b==0 ? "Vô số nghiệm": "Vô nghiệm");
                } else {
                    System.out.println("x is " + ((- b) / a));
                }
            }else{
                System.out.print("Input a in ax+b=c");
                double a = sc.nextDouble();
                System.out.print("Input b in ax+b=c");
                double b = sc.nextDouble();
                System.out.print("Input c in ax+b=c");
                double c = sc.nextDouble();

                if (a == 0) {
                    if (b == 0) {
                        System.out.println(c == 0 ? "Vô số nghiệm." : "Vô nghiệm.");
                    } else {
                        System.out.println("Nghiệm x = " + (-c / b));
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta > 0) {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        System.out.println("Có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
                    } else if (delta == 0) {
                        System.out.println("Có nghiệm kép: x = " + (-b / (2 * a)));
                    } else {
                        System.out.println("Phương trình vô nghiệm");
                    }
                }
            }
        }else{
            System.out.print("a11: "); double a11 = sc.nextDouble();
            System.out.print("a12: "); double a12 = sc.nextDouble();
            System.out.print("b1:  "); double b1 = sc.nextDouble();
            System.out.print("a21: "); double a21 = sc.nextDouble();
            System.out.print("a22: "); double a22 = sc.nextDouble();
            System.out.print("b2:  "); double b2 = sc.nextDouble();

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D != 0) {
                System.out.println("Nghiệm: x1 = " + (D1 / D) + ", x2 = " + (D2 / D));
            } else {
                if (D1 == 0 && D2 == 0) {
                    System.out.println("Vô số nghiệm.");
                } else {
                    System.out.println("Vô nghiệm.");
                }
            }

        }
    }
}
