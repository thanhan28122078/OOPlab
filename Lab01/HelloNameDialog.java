package OOPlab.Lab01;
import javax.swing.JOptionPane;
public class HelloNameDialog {
    static void main() {
        String res;
        res = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null, "Hi" + res + "!");
        System.exit(0);
    }
}
