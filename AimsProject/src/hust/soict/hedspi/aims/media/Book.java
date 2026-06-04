package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    //Constructor

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }


    public List<String> getAuthors() {

        return authors;
    }

    public void setAuthors(List<String> authors) {

        this.authors = authors;
    }

    public String toString() {
        return "Book - Title: " + getTitle() + " - Category: " + getCategory() + " - Authors: " + getAuthors();
    }

    public boolean addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            return true;
        }
        return false;
    }

    public boolean removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            return true;
        }
        return false;
    }

}