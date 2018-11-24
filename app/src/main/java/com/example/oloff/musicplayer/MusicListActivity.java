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
    private ArrayList<Music> musicList =new ArrayList<Music>();
    private myAdapter listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_activity);

        MediaPlayer song = new MediaPlayer();
        MediaPlayer.create(super.getApplicationContext(), R.raw.kaleo);
        musicList.add(new Music(song,"Blanck","Rock","Kaleo1","Gaur1"));
        musicList.add(new Music(song,"Blanck","Rock","Kaleo2","Gaur2"));

        //initialize the Adapter
        listItem = new myAdapter(this,  musicList);
        //find listView by id
        ListView listView = (ListView) findViewById(R.id.list_view);

        //define Adapter for listView
        listView.setAdapter(listItem);
    }
    class data{
        private String name;
        private String author;
        public data(String name,String author){
            this.name = name;
            this.author = author;
        }
        public String getName(){
            return this.name;
        }
        public String getAuthor(){
            return this.author;
        }
    }

    public class myAdapter extends ArrayAdapter<Music> {
        public myAdapter(Context context, ArrayList<Music> musics) {
            super(context, R.layout.music_activity, musics);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Music music = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.music_list_item_view, parent, false);
            }

            TextView rank = (TextView) convertView.findViewById(R.id.rank);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView author = (TextView) convertView.findViewById(R.id.author);
            //ImageView like = (ImageView) convertView.findViewById(R.id.like);

            rank.setText(1+"");
            name.setText(music.getAuthor());
            author.setText(music.getName());
            // Return the completed view to render on screen
            return convertView;
        }
    }
}
