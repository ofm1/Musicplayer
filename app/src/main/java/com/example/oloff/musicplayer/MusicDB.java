package com.example.oloff.musicplayer;

import android.media.MediaPlayer;

import java.util.ArrayList;

public class MusicDB {
    private static MusicDB mInstance= null;

    public ArrayList<Music> allMusics = new ArrayList<Music> ();
    public ArrayList<Integer> myFavorite = new ArrayList<Integer>();
    public int songPlaying = -1;
    public String genre="";
   public String subGenre="";

    protected MusicDB(){
        allMusics.add(new Music(0,	    R.raw.s01 ,	 "Rock" , "Grunge" ,"What About Us 					","P!nk 	 									",198));
        allMusics.add(new Music(1,	    R.raw.s02 ,	 "Rock" , "Grunge" ,"You re The Best Thing About Me	","U2 	 										",202));
        allMusics.add(new Music(2,	    R.raw.s03 ,	 "Rock" , "Grunge" ,"Friends							","Justin Bieber,Ft BloodPop	 				",6));
        allMusics.add(new Music(3,	    R.raw.s04 ,	 "Rock" , "Punk" ,"Riccione						    ","TheGiornalisti 	 							",2));
        allMusics.add(new Music(4,	    R.raw.s05 ,	 "Rock" , "Punk" ,"Katchi							    ","Ofenbach Nick Waterhouse 	 				",24));
        allMusics.add(new Music(5,	    R.raw.s06 ,	 "Pop" , "Punk" ,"Pezzo di me						    ","Levante feat Max Gazze 	  					",18));
        allMusics.add(new Music(6,	    R.raw.s07 ,	 "Pop" , "Punk" ,"L'esercito del selfie			    ","Takagi  Ketra feat. Lorenzo Fragola, Arisa 	",303));
        allMusics.add(new Music(7,	    R.raw.s08 ,	 "Pop" , "Grunge" ,"Dusk Till Dawn					","ZAYN feat. Sia 	 							",292));
        allMusics.add(new Music(8,	    R.raw.s09 ,	 "Pop" , "Grunge" ,"Duri da battere					","Max Pezzali feat. Francesco Renga, Nek 	 	",666));
        allMusics.add(new Music(9,	    R.raw.s10,	 "Pop" , "Grunge" ,"Too Much to Ask					","Niall Horan 	 								",77));
        allMusics.add(new Music(10,	R.raw.s11,	 "Jazz" , "Cool" ,"Scelgo Ancora Te				    ","Giorgia 	 									",55));
        allMusics.add(new Music(11,	R.raw.s12,	 "Jazz" , "Cool" ,"Too Good At Goodbyes			    ","Sam Smith 	 								",23));
        allMusics.add(new Music(12,	R.raw.s13,	 "Jazz" , "Cool" ,"Mi Gente						    ","J. Balvin, Willy William 	 				",1000));
        allMusics.add(new Music(13,	R.raw.s14,	 "Jazz" , "Cool" ,"Vulcano							","Francesca Michielin							",23));
        allMusics.add(new Music(14,	R.raw.s15,	 "Jazz" , "Free" ,"Voglio ballare con te			    ","Baby K ft. Andrés Dvicio 	 				",1));
        allMusics.add(new Music(15,	R.raw.s16,	 "Jazz" , "Free" ,"Without You						","Avicii feat. Sandro Cavazza  	 			",9));
        allMusics.add(new Music(16,	R.raw.s17,	 "Pop" , "Indie" ,"Tutto Per Una Ragione			    ","Benji & Fede ft Annalisa 	 				",22));
        allMusics.add(new Music(17,	R.raw.s18,	 "Pop" , "Indie" ,"Look What You Made Me Do		    ","Taylor Swift 	 							",123));
        allMusics.add(new Music(18,	R.raw.s19,	 "Pop" , "Indie" ,"Versace on The Floor			    ","Bruno Mars vs David Guetta 	 				",100));
        allMusics.add(new Music(19,	R.raw.s20,	 "Pop" , "Indie" ,"There's Nothing Holdin' Me Back  ","Shawn Mendes 	 							    ",10));

        myFavorite.add(1);
        myFavorite.add(2);
        myFavorite.add(4);
        myFavorite.add(5);
        myFavorite.add(10);
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setSubGenre(String subGenre){
        this.subGenre=subGenre;
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
    public void setSongPlaying(int id){
        this.songPlaying=id;
    }
    public int getSongPlaying(){
        return this.songPlaying;
    }
    public boolean isMyFavorite(int id){
        for(int i=0;i<myFavorite.size();i++){
            if(myFavorite.get(i)==id){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Music> getRandom(){

        return allMusics;
    }
}
