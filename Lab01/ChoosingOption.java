package OOPlab.Lab01;
import javax.swing.JOptionPane;
public class ChoosingOption {
    static void main() {
        int opt = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (opt==JOptionPane.YES_NO_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
