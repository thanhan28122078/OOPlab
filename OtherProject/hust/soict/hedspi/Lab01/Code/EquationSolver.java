import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog("Trinh Thanh An -20235633 \n Choose an equation to solve:\n1. First-degree equation with one variable\n2. System of first-degree equations with two variables\n3. Second-degree equation with one variable");
        int option = Integer.parseInt(choice);
        
        switch (option) {
            case 1:
                double a = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a for ax + b = 0:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient b for ax + b = 0:"));
                
                if (a == 0) {
                    JOptionPane.showMessageDialog(null, "Invalid equation (a cannot be 0)");
                } else {
                    double x = -b / a;
                    JOptionPane.showMessageDialog(null, "Solution: x = " + x);
                }
                break;
            
            case 2:
                double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
                double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
                double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
                double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));
                
                double D = a11 * a22 - a12 * a21;
                double Dx = b1 * a22 - b2 * a12;
                double Dy = a11 * b2 - a21 * b1;
                
                if (D == 0) {
                    if (Dx == 0 && Dy == 0) {
                        JOptionPane.showMessageDialog(null, "Infinite solutions");
                    } else {
                        JOptionPane.showMessageDialog(null, "No solution");
                    }
                } else {
                    double x1 = Dx / D;
                    double x2 = Dy / D;
                    JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + ", x2 = " + x2);
                }
                break;
            
            case 3:
                double aq = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a for ax^2 + bx + c = 0:"));
                double bq = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient b for ax^2 + bx + c = 0:"));
                double c = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient c for ax^2 + bx + c = 0:"));
                
                if (aq == 0) {
                    JOptionPane.showMessageDialog(null, "Invalid equation (a cannot be 0)");
                } else {
                    double delta = bq * bq - 4 * aq * c;
                    if (delta > 0) {
                        double x1 = (-bq + Math.sqrt(delta)) / (2 * aq);
                        double x2 = (-bq - Math.sqrt(delta)) / (2 * aq);
                        JOptionPane.showMessageDialog(null, "Two distinct solutions: x1 = " + x1 + ", x2 = " + x2);
                    } else if (delta == 0) {
                        double x = -bq / (2 * aq);
                        JOptionPane.showMessageDialog(null, "One double root: x = " + x);
                    } else {
                        JOptionPane.showMessageDialog(null, "No real solution");
                    }
                }
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }
}