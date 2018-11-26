package com.example.oloff.musicplayer;

import android.media.MediaPlayer;

/**
 * Created by Ólöf on 24.11.2018.
 */

class Music {

    //id
    private int id;
    // the song
    private int song;
    // the section the song belongs to
    private String section;
    // the subclass the song belongs to
    private String sublcalss;
    // name of the song
    private String name;
    // name of the band/singer
    private String author;
    // like count, init is 0
    private int like = 0;

    public Music(int id, int song , String section, String subclass, String name, String author) {
        this.id = id;
        this.song = song;
        this.section = section;
        this.sublcalss = subclass;
        this.name = name;
        this.author = author;
    }

    public Music(int id, int song , String section, String subclass, String name, String author, int like) {
        this.id = id;
        this.song = song;
        this.section = section;
        this.sublcalss = subclass;
        this.name = name;
        this.author = author;
        this.like = like;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
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

    //to get the song's name
    public String getName(){
        return this.name;
    }
    //to get the song's author
    public String getAuthor(){
        return this.author;
    }
    //to add a like to music
    public void addLike(){
        this.like += 1;
    }
    // to get the like count for this music
    public int getLike(){
        return this.like;
    }
    public int getId(){
        return this.id;
    }
}

