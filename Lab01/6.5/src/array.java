import java.util.Arrays;
import java.util.Scanner;
public class array {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        double[] arr = new double[n];

        System.out.println("Enter " + n + " numeric values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        Arrays.sort(arr);

        double s = 0;
        for (double num : arr) {
            s += num;
        }
        double average = s / n;

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum of elements: " + s);
        System.out.printf("Average value: %.2f\n", average);
    }

}
