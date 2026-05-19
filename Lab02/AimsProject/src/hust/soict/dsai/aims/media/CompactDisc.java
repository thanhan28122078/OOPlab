package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public String getArtist() { return artist; }

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' đã tồn tại trong CD.");
        } else {
            tracks.add(track);
            System.out.println("Đã thêm track: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa track: " + track.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' không tồn tại trong CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("--- Playing CD: " + this.getTitle() + " by " + this.getArtist() + " ---");
        System.out.println("Total tracks: " + this.tracks.size() + " | Total length: " + this.getLength());
        System.out.println("------------------------------------------------");

        for (Track track : tracks) {
            track.play();
            System.out.println("-");
        }
    }
}