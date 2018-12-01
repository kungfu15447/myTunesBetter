/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;

/**
 *
 * @author bonde
 */
public class Song
{
    private int id;
    private String title;
    private int length;
    private String artist;
    private String genre;
    private String filepath;
    
    public Song (int id, String title, int duration, String author, String genre, String filepath) {
        this.id = id;
        this.title = title;
        this.length = duration;
        this.artist = author;
        this.genre = genre;
        this.filepath = filepath;
    }
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getLength() {
        return length;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getFilepath()
    {
        return filepath;
    }
    
    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }
    
    @Override
    public String toString() {
        return title + " " + artist + " " + genre + " " + Integer.toString(length);
    }
}
