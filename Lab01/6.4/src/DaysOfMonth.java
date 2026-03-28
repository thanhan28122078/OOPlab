import java.util.Scanner;
public class DaysOfMonth {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int year = -1;

        while (true) {
            System.out.print("Enter a month: ");
            String monthInput = sc.nextLine().trim();

            month = getmonth(monthInput);

            System.out.print("Enter a year (non-negative number, 4 digits): ");
            String yearInput = sc.nextLine().trim();

            if (yearInput.matches("\\d+") && yearInput.length() == 4) {
                year = Integer.parseInt(yearInput);
            } else {
                year = -1;
            }

            if (month != -1 && year != -1) {
                break;
            } else {
                System.out.println("Invalid month or year. Please try again.\n");
            }
        }

        int days = calculateDays(month, year);
        System.out.println("Number of days: " + days);
        sc.close();
    }

    private static int getmonth(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    private static int calculateDays(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // Leap year check: divisible by 4, not 100, or divisible by 400
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}
