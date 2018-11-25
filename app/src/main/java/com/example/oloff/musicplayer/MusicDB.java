package com.example.oloff.musicplayer;

import android.media.MediaPlayer;

import java.util.ArrayList;

public class MusicDB {
    private static MusicDB mInstance= null;

    public ArrayList<Music> allMusics = new ArrayList<Music> ();
    public ArrayList<Integer> myFavorite = new ArrayList<Integer>();

    protected MusicDB(){
        allMusics.add(new Music(0,R.raw.kaleo,"POP","TOP","Kaleo0","Gaur1"));
        allMusics.add(new Music(1,R.raw.kaleo,"POP","TOP","Kaleo1","Gaur1"));
        allMusics.add(new Music(2,R.raw.kaleo,"POP","INDIE","Kaleo2","Gaur2"));
        allMusics.add(new Music(3,R.raw.kaleo,"JAZZ","COOL","Kaleo3","Gaur1"));
        allMusics.add(new Music(4,R.raw.kaleo,"JAZZ","COOL","Kaleo4","Gaur2"));
        allMusics.add(new Music(5,R.raw.kaleo,"JAZZ","DARK","Kaleo5","Gaur1"));
        allMusics.add(new Music(6,R.raw.kaleo,"POP","TOP","Kaleo6","Gaur2"));

        myFavorite.add(1);
        myFavorite.add(2);
        myFavorite.add(4);
    }

    public static synchronized MusicDB getInstance() {
        if(null == mInstance){
            mInstance = new MusicDB();
        }
        return mInstance;
    }
    public ArrayList<Music> getMyFavorite(){
        ArrayList<Music> list = new ArrayList<Music>();
        for (int i = 0; i<myFavorite.size();i++){
            list.add(allMusics.get(myFavorite.get(i)));
        }
        return list;
    }

    public ArrayList<Music> getBySection(String section){
        ArrayList<Music> list = new ArrayList<Music>();
        for (int i = 0; i<allMusics.size();i++){
            if(allMusics.get(i).getSection()==section){
                list.add(allMusics.get(i));
            }
        }
        return list;
    }
    public ArrayList<Music> getBySubClass(String subClass){
        ArrayList<Music> list = new ArrayList<Music>();
        for (int i = 0; i<allMusics.size();i++){
            if(allMusics.get(i).getSublcalss()==subClass){
                list.add(allMusics.get(i));
            }
        }
        return list;
    }
    public ArrayList<Music> getBySectionAndSubClass(String section,String subClass){
        ArrayList<Music> list = new ArrayList<Music>();
        for (int i = 0; i<allMusics.size();i++){
            if(allMusics.get(i).getSublcalss()==subClass&&allMusics.get(i).getSection()==section){
                list.add(allMusics.get(i));
            }
        }
        return list;
    }
}
