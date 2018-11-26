package com.example.oloff.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BrowseActivity extends AppCompatActivity {

    // Start with one song, kaleo - vor í vaglasógi
    MediaPlayer song;





    public void openYourSongs(View view) {
        Intent intent = new Intent(this, MusicListActivity.class);
        startActivity(intent);
    }

    public void openBrowseScreen(View view) {
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse);



    }

}
