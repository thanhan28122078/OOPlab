
import java.util.Scanner;
public class DrawStar {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height: ");
        int h = sc.nextInt();

            int c;
            for (c =1; c <=h; c += 1){
                int i;
                for (i=1; i<=h-c; i++){
                    System.out.print(" ");
                }
                int j;
                for (j=1; j<=(2*c -1); j++) {
                    System.out.print("*");
                }
                for (i=1; i<=h-c; i++){
                    System.out.print(" ");
                }
                System.out.println(" ");
            }

    }
}
