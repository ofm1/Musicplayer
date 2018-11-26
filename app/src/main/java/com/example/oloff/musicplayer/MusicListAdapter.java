package com.example.oloff.musicplayer;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicListAdapter extends ArrayAdapter<Music> {
    public MusicListAdapter(Context context, ArrayList<Music> musics) {
        super(context, R.layout.music_activity, musics);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Music music = getItem(position);

        int songPlaying=MusicDB.getInstance().songPlaying;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.music_list_item_view, parent, false);
        }
        TextView rank = (TextView) convertView.findViewById(R.id.rank);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView like = (TextView) convertView.findViewById(R.id.like);
        final ImageButton likeheart = (ImageButton) convertView.findViewById(R.id.likeheart);

        if(songPlaying==music.getId()){
            rank.setTypeface(rank.getTypeface(),Typeface.BOLD);
            name.setTypeface(rank.getTypeface(),Typeface.BOLD);
            author.setTypeface(rank.getTypeface(),Typeface.BOLD);
            like.setTypeface(rank.getTypeface(),Typeface.BOLD);
        } else {
            rank.setTypeface(rank.getTypeface(),Typeface.NORMAL);
            name.setTypeface(rank.getTypeface(),Typeface.NORMAL);
            author.setTypeface(rank.getTypeface(),Typeface.NORMAL);
            like.setTypeface(rank.getTypeface(),Typeface.NORMAL);
        }
        if(MusicDB.getInstance().isMyFavorite(music.getId())){
            likeheart.setBackgroundResource(R.drawable.likeheart);
        }
        rank.setText(""+music.getId());
        name.setText(music.getName());
        author.setText(music.getAuthor());
        like.setText(""+music.getLike());
        likeheart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(!MusicDB.getInstance().isMyFavorite(music.getId())){
                    MusicDB.getInstance().myFavorite.add(music.getId());
                    likeheart.setBackgroundResource(R.drawable.likeheart);
                }
            }

        });
        // Return the completed view to render on screen
        return convertView;
    }
}
