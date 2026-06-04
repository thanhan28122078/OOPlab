// Example 3: HelloNameDialog.java
//Trinh Thanh An - 20235633
import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
	JOptionPane.showMessageDialog(null, "20235633 - Trinh Thanh An");
        String result;
        result = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + result + "!");
        System.exit(0);
    }
}