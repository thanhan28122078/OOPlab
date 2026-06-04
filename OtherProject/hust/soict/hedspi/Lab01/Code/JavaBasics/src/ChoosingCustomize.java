
import javax.swing.JOptionPane;

public class ChoosingCustomize {
    public static void main(String[] args) {
        String[] options = {"I do", "I don't"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "20235633 - Trinh Thanh An \n Bạn có muốn đổi sang vé hạng nhất không?",
                "Chọn một tùy chọn",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);  // Mặc định chọn "Yes"

        JOptionPane.showMessageDialog(null, "Bạn đã chọn: " + options[choice]);
    }
}
