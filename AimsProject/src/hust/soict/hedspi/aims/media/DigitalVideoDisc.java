package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    //Create a DVD object by title
    public DigitalVideoDisc(String title) {
        super(title);
    }

    //Create a DVD object by category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super( title,category,cost);
    }

    //Create a DVD object by director, category, title and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title,category,director,cost);
    }

    //Create a DVD object by all attributes: title, category, director, length and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title,category,director,length,cost);
    }

    @Override
    public String toString() {
        return "DVD - Title : " + this.getTitle() + " - Category : " + this.getCategory() + " - Director : " + this.getDirector() + " - Length : " + this.getLength() + " - Price : " + this.getCost();
    }


    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
