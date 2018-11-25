package com.example.oloff.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Start with one song, kaleo - vor í vaglasógi
    MediaPlayer song;

    private TextView mTextMessage;

    // button for browse
    private Button mBrowse;

    // button for a random song
    private Button mRandom;

    // button for favorite songs
    private Button mFavorite;

    // button for battle
    private Button mBattle;

    // button to vote
    private Button mVote;

    // button to your songs
    private Button mYourSongs;

    // button for top scores
    private Button mTopScore;

    // button for your account
    private Button mYourAccount;


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
            }
            return false;
        }
    };

    public void openYourSongs(View view) {
        Intent intent = new Intent(this, MusicListActivity.class);
        startActivity(intent);
    }
    
    public void openYourFavorite(View view) {
        Intent intent = new Intent(this, MyFavoriteListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

}
