package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", 19.99f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Science Fiction", 24.99f);
        Book book = new Book("The Lord of the Rings", "Fantasy", 29.99f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for(Media m: mediae) {
            System.out.println(m.toString());
        }
    }
}
