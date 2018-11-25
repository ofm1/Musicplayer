package com.example.oloff.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class MusicListActivity extends AppCompatActivity {
    private ArrayList<Music> musicList;
    private MusicListAdapter listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_activity);

        musicList=MusicDB.getInstance().allMusics;
        //initialize the Adapter
        listItem = new MusicListAdapter(this,  musicList);
        //find listView by id
        ListView listView = (ListView) findViewById(R.id.list_view);

        //define Adapter for listView
        listView.setAdapter(listItem);
    }
}
