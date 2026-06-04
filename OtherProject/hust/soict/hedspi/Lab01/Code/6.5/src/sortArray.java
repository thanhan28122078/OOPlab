import java.util.Arrays;
import java.util.Scanner;

public class sortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Trinh Thanh An - 20235633\n" );
        System.out.print("Do you want to enter the array manually? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        int[] numbers;

        if (choice.equals("yes")) {
            // User enters the array
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();
            numbers = new int[size];

            System.out.println("Enter " + size + " numbers:");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }
        } else {
            // Use a predefined array
            numbers = new int[]{5, 2, 9, 1, 7, 6};
            System.out.println("Using predefined array: " + Arrays.toString(numbers));
        }

        // Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Calculate sum and average
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;

        // Display results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}
