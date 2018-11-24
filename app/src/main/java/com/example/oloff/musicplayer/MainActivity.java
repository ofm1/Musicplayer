package com.example.oloff.musicplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Start with one song, kaleo - vor í vaglasógi
    MediaPlayer song;

    private TextView mTextMessage;

    boolean playing = false;

    private Button mPlayButton;


    private Music[] mMusicBank;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_playpause:
                    // mTextMessage.setText(R.string.title_notifications);

                    if(playing){
                        song.pause();
                        item.setIcon(android.R.drawable.ic_media_play);
                        playing = false;
                    } else {
                        song.start();
                        item.setIcon(android.R.drawable.ic_media_pause);
                        playing = true;
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song = MediaPlayer.create(super.getApplicationContext(), R.raw.kaleo);

        mMusicBank = new Music[]{
                new Music(song,"indie","rock","Vor í vaglaskógi", "kaleo")};


        mPlayButton = (Button) findViewById(R.id.playButton);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing){
                    song.pause();
                    playing = false;
                } else {
                    song.start();
                    playing = true;
                }

            }
        });


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
