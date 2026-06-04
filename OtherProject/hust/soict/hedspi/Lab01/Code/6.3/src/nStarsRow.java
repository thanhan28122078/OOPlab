import java.util.Scanner;

public class nStarsRow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("20235633 - Trinh Thanh An\n ");
        System.out.print("Enter the height of the triangle (n): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            int stars = 2 * i - 1;
            int spaces = n - i;


            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // In dấu *
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            System.out.println(); // Xuống dòng sau mỗi lần in
        }

        scanner.close();
    }
}
