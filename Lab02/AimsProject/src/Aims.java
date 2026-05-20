import hust.soict.dsai.aims.media.*;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = getIntegerInput();
            switch (choice) {
                case 1:
                    viewStoreRoutine();
                    break;
                case 2:
                    updateStoreRoutine();
                    break;
                case 3:
                    viewCartRoutine();
                    break;
                case 0:
                    System.out.println("Thank you for using AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 0 to 3.");
            }
        } while (choice != 0);
    }

    private static void initSampleData() {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        Book book = new Book(2, "Java Programming", "Education", 29.99f);
        book.addAuthor("James Gosling");

        CompactDisc cd = new CompactDisc(3, "Thriller", "Pop", 15.50f, 42, "Quincy Jones", "Michael Jackson");
        cd.addTrack(new Track("Beat It", 4));
        cd.addTrack(new Track("Billie Jean", 5));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);
    }


    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void viewStoreRoutine() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = getIntegerInput();
            switch (choice) {
                case 1: // See media details
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsRoutine(media);
                    } else {
                        System.out.println("No matching media found in the store.");
                    }
                    break;
                case 2: // Add media to cart
                    System.out.print("Enter the title of the media to add to cart: ");
                    String t2 = scanner.nextLine();
                    Media m2 = store.searchByTitle(t2);
                    if (m2 != null) {
                        cart.addMedia(m2);
                    } else {
                        System.out.println("Media not found or invalid title.");
                    }
                    break;
                case 3: // Play a media
                    System.out.print("Enter the title of the media to play: ");
                    String t3 = scanner.nextLine();
                    Media m3 = store.searchByTitle(t3);
                    playMedia(m3);
                    break;
                case 4: // Quick access to Cart view
                    viewCartRoutine();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void mediaDetailsRoutine(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = getIntegerInput();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void updateStoreRoutine() {
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.print("Choose option (1-2): ");
        int choice = getIntegerInput();
        if (choice == 1) {
            System.out.println("Select media type: 1. DVD | 2. CD | 3. Book");
            int type = getIntegerInput();
            System.out.print("Enter ID: "); int id = getIntegerInput();
            System.out.print("Enter Title: "); String title = scanner.nextLine();
            System.out.print("Enter Category: "); String category = scanner.nextLine();
            System.out.print("Enter Cost: "); float cost = getFloatInput();

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(id, title, category, cost, 0, "Unknown"));
            } else if (type == 2) {
                store.addMedia(new CompactDisc(id, title, category, cost, 0, "Unknown", "Unknown"));
            } else if (type == 3) {
                store.addMedia(new Book(id, title, category, cost));
            }
        } else if (choice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) store.removeMedia(m);
            else System.out.println("Media not found in the store configuration.");
        }
    }

    private static void viewCartRoutine() {
        int choice;
        do {
            cart.printCart();
            cartMenu();
            choice = getIntegerInput();
            switch (choice) {
                case 1: // Filter medias
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int filterType = getIntegerInput();
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    // Call your specific Cart filter method here if required
                    break;
                case 2: // Sort medias
                    System.out.println("Sort by: 1. Title | 2. Cost");
                    int sortType = getIntegerInput();
                    if (sortType == 1) cart.sortByTitle();
                    else if (sortType == 2) cart.sortByCost();
                    break;
                case 3: // Remove media from cart
                    System.out.print("Enter the title of the media to remove from cart: ");
                    String titleDel = scanner.nextLine();
                    // You can search through items or directly use your remove methods
                    break;
                case 4: // Play a media from cart
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    break;
                case 5: // Place Order
                    System.out.println("An order has been successfully created! Thank you.");
                    cart = new Cart(); // Empties the cart as per the assignment description simplifying constraints
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        } while (choice != 0);
    }

    private static void playMedia(Media media) {
        if (media == null) {
            System.out.println("Invalid media item.");
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Error: This type of media (e.g., Book) does not support playback features!");
        }
    }

    private static int getIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid format! Please enter an integer: ");
            }
        }
    }

    private static float getFloatInput() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid format! Please enter a float number: ");
            }
        }
    }

}