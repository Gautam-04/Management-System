package Model;

import java.util.ArrayList;

public class Songs implements SongDesc {
    /* Property attributes */
    private int id;
    private String song_name;
    private String song_desc;
    private String song_artist;
    private double song_duration;

    ArrayList<String> song_reviews=new ArrayList<>();
    ArrayList<String> song_critics = new ArrayList<>();
    // Constructor (optional, depending on your use case)
    public Songs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return song_name;
    }

    public void setSongName(String song_name) {
        this.song_name = song_name;
    }

    public String getSongDescription() {
        return song_desc;
    }

    public void setSongDescription(String song_desc) {
        this.song_desc = song_desc;
    }

    public String getSongArtist() {
        return song_artist;
    }

    public void setSongArtist(String song_artist) {
        this.song_artist = song_artist;
    }

    public double getSongDuration() {
        return song_duration;
    }

    public void display()
    {
        System.out.println("Song Id: "+this.getId()+" ,Song Name :"+this.getSongName()+" ,Song Description :"+this.getSongDescription()+" ,Song Artist :"+this.getSongArtist()+" ,Song Duration :"+this.getSongDuration());
    }

    public void setSongDuration(double song_duration) {
        this.song_duration = song_duration;
    }
    @Override
    public void addSongReviews(String objective){this.song_reviews.add(objective);}

    @Override
    public void removeSongReviews(int objective_no) {
        this.song_reviews.remove(objective_no);
    }

    @Override
    public void displaySongReviews() {
        for (int i = 0; i < song_reviews.size(); i++) {
            System.out.println("Course Objective "+i+" : "+song_reviews.get(i));
        }
    }

    @Override
    public void addSongCritics(String outcome){this.song_critics.add(outcome);}

    @Override
    public void removeSongCritics(int outcome_no) {
        this.song_critics.remove(outcome_no);
    }

    @Override
    public void displaySongCritics() {
        for (int i = 0; i < song_critics.size(); i++) {
            System.out.println("Course Objective "+i+" : "+song_critics.get(i));
        }
    }
}