package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private ArrayList<String> authors;
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<String>();
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added " + authorName + "into the list");
        } else {
            System.out.println(authorName + " have been already in the list");
        }
    }


    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Remove " + authorName + " from the list");
        } else {
            System.out.println("Cannot find " + authorName);
        }
    }
    public Book(){}
    @Override
    public String toString() {
        return "Book - ID: " + getId() + " - Title: " + getTitle() + " - Category: " + getCategory() + " - Cost: " + getCost() + " $ - Authors: " + authors;
    }
}
