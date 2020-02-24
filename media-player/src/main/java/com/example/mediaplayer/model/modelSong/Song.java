package com.example.mediaplayer.model.modelSong;

import java.sql.Date;

public class Song {
    private long id;
    private String songName;
    private String dateRelease;
    private long length;
    private String artist;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public static Song create(String songName, String dateRelease, long length, String artist) {
        Song song = new Song();
        song.setSongName(songName);
        song.setDateRelease(dateRelease);
        song.setLength(length);
        song.setArtist(artist);
        return song;
    }

    public void setDateRelease(Date date_of_release) {
        this.dateRelease = dateRelease;
    }
}