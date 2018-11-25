package com.example.oloff.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyFavoriteListActivity extends AppCompatActivity {

    private ArrayList<Music> myFavorite;
    private MusicListAdapter listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_activity);
        myFavorite=MusicDB.getInstance().getMyFavorite();
        //initialize the Adapter
        listItem = new MusicListAdapter(this,  myFavorite);
        //find listView by id
        ListView listView = (ListView) findViewById(R.id.list_view);

        //define Adapter for listView
        listView.setAdapter(listItem);
    }
}
