// Example 5: Caculate.java
// Trinh Thanh An - 20235633
import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("20235633 - Trinh Thanh An\nEnter the first number:");
        String strNum2 = JOptionPane.showInputDialog("20235633 - Trinh Thanh An\nEnter the second number:");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String quotient = (num2 != 0) ? String.valueOf(num1 / num2) : "Undefined (cannot divide by zero)";

        String message = "20235633 - Trinh Thanh An\n" +
                         "Sum: " + sum +
                         "\nDifference: " + difference +
                         "\nProduct: " + product +
                         "\nQuotient: " + quotient;

        JOptionPane.showMessageDialog(null, message, "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
