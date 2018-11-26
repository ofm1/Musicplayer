package com.example.oloff.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        final ListView listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(listItem);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music item = myFavorite.get(position);
                Toast.makeText(getApplicationContext(),"Playing song :"+item.getId(), Toast.LENGTH_SHORT).show();
                MusicDB.getInstance().setSongPlaying(item.getId());
                listView.setAdapter(listItem); //refresh list
                //listItem.notifyDataSetChanged();
            }
        });
        listView.setFocusable(true);
        listView.setFocusableInTouchMode(true);
        listView.setClickable(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicDB.getInstance().songPlaying=-1;
    }
}
