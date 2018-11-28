package com.example.oloff.musicplayer;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        final LinearLayout item = (LinearLayout) convertView.findViewById(R.id.item);
        //final TextView rank = (TextView) convertView.findViewById(R.id.rank);
        final TextView name = (TextView) convertView.findViewById(R.id.name);
        final TextView author = (TextView) convertView.findViewById(R.id.author);
        final TextView like = (TextView) convertView.findViewById(R.id.like);
        final ImageButton likeheart = (ImageButton) convertView.findViewById(R.id.likeheart);

        if(songPlaying==music.getId()){
            //rank.setTypeface(rank.getTypeface(),Typeface.BOLD);
            name.setTypeface(name.getTypeface(),Typeface.BOLD);
            author.setTypeface(author.getTypeface(),Typeface.BOLD);
            like.setTypeface(like.getTypeface(),Typeface.BOLD);
            item.setBackgroundColor(Color.parseColor("#4fff0000"));
        } else {
            //rank.setTypeface(rank.getTypeface(),Typeface.NORMAL);
            name.setTypeface(name.getTypeface(),Typeface.NORMAL);
            author.setTypeface(author.getTypeface(),Typeface.NORMAL);
            like.setTypeface(like.getTypeface(),Typeface.NORMAL);
            item.setBackgroundColor(Color.parseColor("#00000000"));
        }
        if(MusicDB.getInstance().isMyFavorite(music.getId())){
            likeheart.setBackgroundResource(R.drawable.likeheart);
        }
        //rank.setText(""+music.getId());
        String songName = music.getName();
        if (songName.length()>20){
            songName=songName.substring(0, 19)+"...";
        }
        String authorName = music.getAuthor();
        if (authorName.length()>20){
            authorName=authorName.substring(0, 19)+"...";
        }
        name.setText(songName);
        author.setText(authorName);
        like.setText(""+music.getLike());
        likeheart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(!MusicDB.getInstance().isMyFavorite(music.getId())){
                    MusicDB.getInstance().myFavorite.add(music.getId());
                    likeheart.setBackgroundResource(R.drawable.likeheart);
                    int temp = Integer.parseInt((String)like.getText());
                    temp+=1;
                    MusicDB.getInstance().allMusics.get(music.getId()).addLike();
                    like.setText(Integer.toString(temp));
                }
            }

        });
        // Return the completed view to render on screen
        return convertView;
    }
}
