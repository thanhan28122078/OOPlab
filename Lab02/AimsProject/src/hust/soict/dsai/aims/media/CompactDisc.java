package hust.soict.dsai.aims.media;

public class CompactDisc extends Media{
    private String director;
    private int length;

    public int getLength() { return length; }
    public String getDirector() { return director; }

    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director) {
        super();
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.length = length;
        this.director = director;
    }
}
