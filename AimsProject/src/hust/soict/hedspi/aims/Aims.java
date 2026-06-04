package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;


public class Aims {
    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        //Add dvd
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 19.8f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 18.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 15.9f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 17.2f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 20.1f);

        //Add book
        Book book1 = new Book("Dune", "Science Fiction", 18.75f);
        book1.addAuthor("Frank Herbert");
        Book book2 = new Book("The Hobbit", "Fantasy", 14.99f);
        book2.addAuthor("J.R.R. Tolkien");
        Book book3 = new Book("Pride and Prejudice", "Classic", 9.50f);
        book3.addAuthor("Jane Austen");
        Book book4 = new Book("Brave New World", "Dystopian", 13.25f);
        book4.addAuthor("Aldous Huxley");
        Book book5 = new Book("The Alchemist", "Fiction", 11.45f);
        book5.addAuthor("Paulo Coelho");

        //Add CompactDisc
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 40, 15.44f, "Michael Jackson");
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", 53, 18.99f, "AC/DC");
        CompactDisc cd3 = new CompactDisc("The Eminem Show", "Hip-Hop", "Eminem", 62, 20.50f, "Eminem");
        CompactDisc cd4 = new CompactDisc("Beethoven: Symphony No. 9", "Classical", "Berlin Philharmonic", 75, 12.75f, "Berlin Philharmonic");
        CompactDisc cd5 = new CompactDisc("Random Access Memories", "Electronic", "Daft Punk", 48, 22.30f, "Daft Punk");

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);
        store.addMedia(cd5);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    seeMediaDetails(store, cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4");
            }
        } while (choice != 0);
    }

    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            media.displayDetails();
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Media added to hust.soict.hedspi.test1.cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number: 0-1-2");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to hust.soict.hedspi.test1.cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to hust.soict.hedspi.test1.cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to hust.soict.hedspi.test1.store");
        System.out.println("2. Remove a media from hust.soict.hedspi.test1.store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Add media to hust.soict.hedspi.test1.store logic
                addMediaToStore(store, scanner);
                break;
            case 2:
                // Remove media from hust.soict.hedspi.test1.store logic
                removeMediaFromStore(store, scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }

    public static void addMediaToStore(Store store, Scanner scanner) {
        System.out.print("Enter the type of media (CD/DVD/Book): ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("DVD")) {
            scanner.nextLine();
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the director:");
            String director = scanner.nextLine();
            System.out.println("Enter the length:");
            int length = scanner.nextInt();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            System.out.println("DVD added to hust.soict.hedspi.test1.store.");
        } else if (type.equalsIgnoreCase("CD")) {
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the director:");
            String director = scanner.nextLine();
            System.out.println("Enter the length:");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Enter the artist:");
            String artist = scanner.nextLine();
            CompactDisc cd = new CompactDisc(title, category, director, length,cost, artist);
            store.addMedia(cd);
            System.out.println("CD added to hust.soict.hedspi.test1.store.");
        } else if (type.equalsIgnoreCase("Book")) {
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            Book book = new Book(title, category, cost);
            store.addMedia(book);
            System.out.println("Book added to hust.soict.hedspi.test1.store.");
        } else {
            System.out.println("Invalid media type.");
        }
    }

    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        cart.printCart();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    filterMediasInCart(cart, scanner);
                    break;
                case 2:
                    sortMediasInCart(cart, scanner);
                    break;
                case 3:
                    removeFromCart(cart, scanner);
                    break;
                case 4:
                    playMedia(cart, scanner);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4-5");
            }
        } while (choice != 0);
    }

    public static void sortMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                cart.sortByTitleCost();
                break;
            case 2:
                cart.sortByCostTitle();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
        cart.printCart();
    }

    public static void filterMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter the title to filter: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            case 2:
                System.out.print("Enter the ID to filter: ");
                int id = scanner.nextInt();
                cart.searchById(id);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }

    public static void removeFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from hust.soict.hedspi.test1.cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    public static void placeOrder(Cart cart) {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Cart is empty. Nothing to order.");
            return;
        }
        System.out.println("Placing order for " + cart.getItemsOrdered().size() + " items:");
        for (Media media : cart.getItemsOrdered()) {
            System.out.println("- " + media.getTitle() + " (" + media.getCategory() + ")");
        }
        // Tinh tong tien
        double total = cart.totalCost();
        System.out.printf("Total cost: $%.2f%n", total);

        // Xoa all items
        cart.getItemsOrdered().clear();
        System.out.println("Order placed successfully!");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in hust.soict.hedspi.test1.cart");
        System.out.println("2. Sort medias in hust.soict.hedspi.test1.cart");
        System.out.println("3. Remove media from hust.soict.hedspi.test1.cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        System.out.print("Enter your choice: ");
    }

    public static void showMenu () {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View hust.soict.hedspi.test1.store");
        System.out.println("2. Update hust.soict.hedspi.test1.store");
        System.out.println("3. See current hust.soict.hedspi.test1.cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        System.out.print("Enter your choice: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to hust.soict.hedspi.test1.cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current hust.soict.hedspi.test1.cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        System.out.print("Enter your choice: ");
    }
}