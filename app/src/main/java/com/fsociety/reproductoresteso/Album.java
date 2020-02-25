package com.fsociety.reproductoresteso;

public class Album {

    private String artistName;
    private String albumName;
    private int imageAlbum;

    public Album(String artistName,String albumName,int imageAlbum){
        this.albumName=albumName;
        this.artistName=artistName;
        this.imageAlbum=imageAlbum;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getImageAlbum() {
        return imageAlbum;
    }
}
