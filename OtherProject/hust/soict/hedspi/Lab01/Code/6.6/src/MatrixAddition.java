import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Trinh Thanh An - 20235633");
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        scanner.nextLine(); 

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        // Nhập ma trận A 
        System.out.println("Enter elements of Matrix A (row-wise, separated by space):");
        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        // Nhập ma trận B 
        System.out.println("Enter elements of Matrix B (row-wise, separated by space):");
        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        // Cộng hai ma trận
        System.out.println("Sum of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
