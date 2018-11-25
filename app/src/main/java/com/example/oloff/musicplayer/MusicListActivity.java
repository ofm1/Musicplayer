package com.example.oloff.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import android.widget.Toast;

public class MusicListActivity extends AppCompatActivity {
    private ArrayList<Music> musicList;
    private MusicListAdapter listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_activity);

        musicList=MusicDB.getInstance().allMusics;
        final ArrayList<Music> lists = musicList;
        //initialize the Adapter
        listItem = new MusicListAdapter(this,  musicList);
        //find listView by id
        final ListView listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(listItem);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music item = musicList.get(position);
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
