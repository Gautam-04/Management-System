package Model;

public interface SongDesc {

    void addSongReviews(String review);

    void removeSongReviews(int review_no);
    void displaySongReviews();

    void addSongCritics(String critic);
    void removeSongCritics(int critic_no);
    void displaySongCritics();

}
