package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        System.out.println(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

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
        launch(args);
    }
}