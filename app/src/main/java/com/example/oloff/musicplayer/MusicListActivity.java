package com.example.oloff.musicplayer;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MusicListActivity extends AppCompatActivity {
    private ArrayList<Music> musicList;
    private MusicListAdapter listItem;
    private boolean playing = false;
    private boolean isPaused = false;
    private MediaPlayer player = null;
    private static Context context;
    int songPaucePoint;
    final boolean isPlaying(){
        return playing;
    }
    final boolean isPaused(){
        return isPaused;
    }
    final void changeSongState(){
        playing = !playing;
    }
    final void pauseSong(){
        isPaused=true;
    }
    final void resumeSong(){
        isPaused=false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_activity);
        context = this.getApplicationContext();
        loadList();
        final ArrayList<Music> lists = musicList;
        //initialize the Adapter
        listItem = new MusicListAdapter(this,  musicList);
        //find listView by id
        final ListView listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(listItem);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean songChange = false;
                Music item = musicList.get(position);
                //Toast.makeText(getApplicationContext(),"Playing song :"+item.getId(), Toast.LENGTH_SHORT).show();
                if(MusicDB.getInstance().songPlaying!= item.getId()){
                    songChange=true;
                }
                MusicDB.getInstance().setSongPlaying(item.getId());
                freshList();//refresh list
                ImageButton pause = (ImageButton) findViewById(R.id.pauseSong);
                //pause resume and nextSong
                if(!isPlaying()){
                    pause.setBackgroundResource(R.drawable.pause);
                    playMusic();
                } else {
                    if(songChange){
                        playMusic();
                        songPaucePoint=0;
                        pause.setBackgroundResource(R.drawable.pause);
                    } else {
                        if(!isPaused()){
                            player.pause();
                            songPaucePoint=player.getCurrentPosition();
                            pauseSong();
                            pause.setBackgroundResource(R.drawable.play);
                        } else {
                            player.seekTo(songPaucePoint);
                            player.start();
                            resumeSong();
                            songPaucePoint=0;
                            pause.setBackgroundResource(R.drawable.pause);
                        }
                    }
                }
            }
        });
        listView.setFocusable(true);
        listView.setFocusableInTouchMode(true);
        listView.setClickable(true);

        final ImageButton nextSong = (ImageButton) findViewById(R.id.nextSong);
        final ImageButton previousSong = (ImageButton) findViewById(R.id.previousSong);
        final ImageButton pauseSong = (ImageButton) findViewById(R.id.pauseSong);

        pauseSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseSongButton();
            }
        });
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseSong.setBackgroundResource(R.drawable.pause);
                nextSong();
            }
        });
        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseSong.setBackgroundResource(R.drawable.pause);
                preSong();
            }
        });
    }

    private void freshList(){
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(listItem); //refresh list
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        MusicDB.getInstance().songPlaying=-1;
        if(player!=null){
            player.release();
            player = null;
        }
    }
    //play music if no stop then it will go for next song on the list
    public void playMusic() {
        Toast.makeText(getApplicationContext(),"Song True:", Toast.LENGTH_SHORT).show();
        try {
            if(player!=null)player.release();

            player = new MediaPlayer();
            Music currentSong = musicList.get(checkIndexInSongList(MusicDB.getInstance().songPlaying));
            player = MediaPlayer.create(context,currentSong.getSong());
            //player.prepare();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    nextSong();
                }
            });
            playing = true;
            player.start();
            Toast.makeText(getApplicationContext(),"try:", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"except:", Toast.LENGTH_SHORT).show();
        }
    }
    public void nextSong() {
        int next = checkIndexInSongList(MusicDB.getInstance().songPlaying)+1;
        int numOfSong = musicList.size() ;
        if(next < numOfSong){
            MusicDB.getInstance().songPlaying = musicList.get(next).getId();
            playMusic();
        }/*
        if (MusicDB.getInstance().songPlaying < numOfSong - 1) {
            MusicDB.getInstance().songPlaying++;
            Log.d("my_log", "position = "+MusicDB.getInstance().songPlaying);
            playMusic();
        } else {
            MusicDB.getInstance().songPlaying = 0;
            Log.d("my_log", "position = "+MusicDB.getInstance().songPlaying);
            playMusic();
        }*/
        else {
            MusicDB.getInstance().songPlaying = musicList.get(0).getId();
            playMusic();
        }
        freshList();
    }
    public void preSong() {
        int next = checkIndexInSongList(MusicDB.getInstance().songPlaying)-1;
        int numOfSong = musicList.size() ;
        if(next >= 0){
            MusicDB.getInstance().songPlaying = musicList.get(next).getId();
            playMusic();
        }/*
        if (MusicDB.getInstance().songPlaying < numOfSong - 1) {
            MusicDB.getInstance().songPlaying++;
            Log.d("my_log", "position = "+MusicDB.getInstance().songPlaying);
            playMusic();
        } else {
            MusicDB.getInstance().songPlaying = 0;
            Log.d("my_log", "position = "+MusicDB.getInstance().songPlaying);
            playMusic();
        }*/
        else {
            MusicDB.getInstance().songPlaying = musicList.get(numOfSong-1).getId();
            playMusic();
        }
        freshList();
    }
    public void loadList(){
        String genre = MusicDB.getInstance().genre;
        String subGenre = MusicDB.getInstance().subGenre;
        if(genre=="" && subGenre==""){
            musicList=MusicDB.getInstance().allMusics;
            setTitle("All Songs");
        } else if (subGenre==""){
            if(genre=="myFavorite") {
                setTitle("Favorite Songs");
                musicList = MusicDB.getInstance().getMyFavorite();
            } else if(genre == "random") {
                musicList = MusicDB.getInstance().getRandom();
                setTitle("Random Songs");
            } else {
                musicList = MusicDB.getInstance().getBySection(genre);
                setTitle(genre+" Songs");
            }
        } else {
            musicList = MusicDB.getInstance().getBySectionAndSubClass(genre, subGenre);
            setTitle(genre+"-"+subGenre+" Songs");
        }
    }
    public int checkIndexInSongList(int id){
        int index = -1;
        for(int i =0; i<musicList.size();i++){
            Music temp = musicList.get(i);
            if(temp.getId()==id){
                index = i;
                break;
            }
        }
        return index;
    }
    public void pauseSongButton(){
        if(isPlaying()){
            ImageButton pause = (ImageButton) findViewById(R.id.pauseSong);
            if(!isPaused()){
                player.pause();
                songPaucePoint=player.getCurrentPosition();
                pauseSong();
                pause.setBackgroundResource(R.drawable.play);
            } else {
                player.seekTo(songPaucePoint);
                player.start();
                resumeSong();
                songPaucePoint = 0;
                pause.setBackgroundResource(R.drawable.pause);
            }
        }
    }
}
