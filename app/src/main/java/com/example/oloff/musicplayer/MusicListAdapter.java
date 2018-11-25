package com.example.oloff.musicplayer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicListAdapter extends ArrayAdapter<Music> {
    public MusicListAdapter(Context context, ArrayList<Music> musics) {
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

        rank.setText(""+music.getId());
        name.setText(music.getAuthor());
        author.setText(music.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
