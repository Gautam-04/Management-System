package Model;

/**
 * Identification comments:
 *   Name: Aadil , Gautam
 *   Experiment No: 6
 *   Experiment Title:
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Student.java
 * @author:  Aadil, Gautam
 * /*  Overview: This class is created to store the attributes of Student. It is a subclass of the class "Person" which inherits
some of the attributes from the Person class. And the class representing the "Person" object implements the interface named
"Table Member".
 *
 * Attribute comments:
 * id : Its Student Id
 * Name :
 * DOB :
 *
 *
 */

public class Listener extends Person{

    /* Student attributes */
    private String favourite_genre;

    private String favourite_artist;


    public Listener(int ListenerId, String name, long mobile_no, String email, String gender, String  favourite_artist, String favourite_genre)
    {
        super(ListenerId ,name,mobile_no,email, gender);
        setFavourite_genre(favourite_genre);
        setFavourite_artist(favourite_artist);
    }

    public Listener(String name, long mobile_no, String email, String gender, String  favourite_artist, String favourite_genre)
    {
        super(name, mobile_no, email, gender);
        setFavourite_genre(favourite_genre);
        setFavourite_artist(favourite_artist);
    }

    public void setFavourite_genre(String favourite_genre){this.favourite_genre = favourite_genre;}
    public String getFavourite_genre(){return this.favourite_genre;}

    public void setFavourite_artist(String favourite_artist){this.favourite_artist = favourite_artist;}
    public String getFavourite_artist(){return this.favourite_artist;}

    public String displayListener()
    {
        return display()+" ,Favourite Genre: "+this.getFavourite_genre()+" ,Favourite Artist: "+this.getFavourite_artist();
    }
}