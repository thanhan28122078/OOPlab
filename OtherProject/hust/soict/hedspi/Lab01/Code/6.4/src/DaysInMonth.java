import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Trinh Thanh An - 20235633");
        Map<String, Integer> monthMap = new HashMap<>();
        String[][] monthNames = {
                {"January", "Jan.", "Jan", "1"},
                {"February", "Feb.", "Feb", "2"},
                {"March", "Mar.", "Mar", "3"},
                {"April", "Apr.", "Apr", "4"},
                {"May", "May", "May", "5"},
                {"June", "Jun.", "Jun", "6"},
                {"July", "Jul.", "Jul", "7"},
                {"August", "Aug.", "Aug", "8"},
                {"September", "Sept.", "Sep", "9"},
                {"October", "Oct.", "Oct", "10"},
                {"November", "Nov.", "Nov", "11"},
                {"December", "Dec.", "Dec", "12"}
        };

        // Populate the map with month names
        for (int i = 0; i < monthNames.length; i++) {
            for (String name : monthNames[i]) {
                monthMap.put(name.toLowerCase(), i + 1);
            }
        }

        int month = 0, year = -1;

        // Get valid month input
        while (month == 0) {
            System.out.print("Enter a month (name, abbreviation, or number): ");
            String inputMonth = scanner.nextLine().trim().toLowerCase();
            if (monthMap.containsKey(inputMonth)) {
                month = monthMap.get(inputMonth);
            } else {
                System.out.println("Invalid month. Please enter again.");
            }
        }

        // Get valid year input
        while (year < 0) {
            System.out.print("Enter a year (non-negative integer): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Invalid year. Please enter again.");
                }
            } else {
                System.out.println("Invalid year. Please enter again.");
                scanner.next(); // Consume invalid input
            }
        }

        // Determine number of days in the month
        int days;
        switch (month) {
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = (isLeapYear(year)) ? 29 : 28;
                break;
            default:
                days = 31;
        }

        System.out.println("The month has " + days + " days.");
        scanner.close();
    }

    // Method to determine if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
