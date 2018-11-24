package com.example.oloff.musicplayer;

import android.media.MediaPlayer;

/**
 * Created by Ólöf on 24.11.2018.
 */

class Music {

    // the song
    private MediaPlayer song;
    // the section the song belongs to
    private String section;
    // the subclass the song belongs to
    private String sublcalss;
    // name of the song
    private String name;
    // name of the band/singer
    private String author;

    public Music(MediaPlayer song , String section, String subclass, String name, String author) {
       this.song = song;
       this.section = section;
       this.sublcalss = subclass;
       this.name = name;
       this.author = author;
    }

    public MediaPlayer getSong() {
        return song;
    }

    public void setSong(MediaPlayer song) {
        this.song = song;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSublcalss() {
        return sublcalss;
    }

    public void setSublcalss(String sublcalss) {
        this.sublcalss = sublcalss;
    }
}

