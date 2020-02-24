package com.example.mediaplayer.model.modelArtist;

import com.example.mediaplayer.model.modelSong.Song;

import java.sql.Date;

public class Artist {
    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String genre;
    private String artistName;

    public Artist(long id, String firstName, String lastName, String dateOfBirth, String genre, String artistName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.genre = genre;
        this.artistName = artistName;
    }

    public Artist() {

    }

    public static Artist create(String firstName, String lastName, String dateOfBirth, String genre, String artistName) {
        Artist artist = new Artist();
        artist.setFirstName(firstName);
        artist.setLastName(lastName);
        artist.setDateOfBirth(dateOfBirth);
        artist.setGenre(genre);
        artist.setArtistName(artistName);
        return artist;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", genre='" + genre + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = dateOfBirth;

    }
}
