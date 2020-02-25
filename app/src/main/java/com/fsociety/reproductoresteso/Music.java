package com.fsociety.reproductoresteso;

class Music {
    private String nameSong;
    private String timeSong;
    private int song;

    public Music(String nameSong, String timeSong, int song){
        this.nameSong=nameSong;
        this.timeSong=timeSong;
        this.song=song;
    }

    public String getNameSong() {
        return nameSong;
    }

    public String getTimeSong() {
        return timeSong;
    }

    public int getSong() {
        return song;
    }
}
