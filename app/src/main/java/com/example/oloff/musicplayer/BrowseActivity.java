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

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {

    // Start with one song, kaleo - vor í vaglasógi
    MediaPlayer song;



    private Button mAllSongs;

    // rock buttons
    private Button mRockPunk;
    private Button mRockGrunge;
    private Button mRockIndie;
    private Button mRockHeavy;
    private Button mRockFolk;
    private Button mRockBeat;
    private Button mRockAll;

    // pop buttons
    private Button mPopAll;
    private Button mPopPunk;
    private Button mPopIndie;
    private Button mPopFolk;
    private Button mPopBeat;
    private Button mPopDisco;


    // jazz buttons
    private Button mJazzAll;
    private Button mJazzCool;
    private Button mJazzHeavy;
    private Button mJazzBeat;
    private Button mJazzSoul;
    private Button mJazzFree;
    private Button mJazzFolk;

    // country buttons
    private Button mCountryAll;
    private Button mCountryRock;
    private Button mCountryIndie;
    private Button mCountryFolk;
    private Button mCountryBeat;

    // Blues buttons
    private Button mBluesAll;
    private Button mBluesCool;
    private Button mBluesIndie;
    private Button mBluesFolk;
    private Button mBluesBeat;

    public void openYourSongs(View view) {
        Intent intent = new Intent(this, MusicListActivity.class);
        startActivity(intent);
    }

    public void openBrowseScreen(View view) {
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
    }

    private void setGenreandSubGenre(String genre, String subGenre) {
            MusicDB.getInstance().setGenre(genre);
            MusicDB.getInstance().setSubGenre(subGenre);
            startActivity(new Intent(BrowseActivity.this, MusicListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse);

        mAllSongs = (Button) findViewById(R.id.allSongs);

        mAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("","");
            }
        });

        mRockAll = (Button) findViewById(R.id.allRock);
        mRockBeat = (Button) findViewById(R.id.beatRock);
        mRockFolk = (Button) findViewById(R.id.folkRock);
        mRockPunk = (Button) findViewById(R.id.punkRock);
        mRockGrunge = (Button) findViewById(R.id.grungeRock);
        mRockHeavy = (Button) findViewById(R.id.heavyRock);
        mRockIndie = (Button) findViewById(R.id.indieRock);

        mRockAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","");
            }
        });
        mRockBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","Beat");
            }
        });
        mRockPunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","Punk");
            }
        });
        mRockFolk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","Folk");
            }
        });
        mRockGrunge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","Grunge");
            }
        });
        mRockHeavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","Heavy");
            }
        });
        mRockIndie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Rock","Indie");
            }
        });

        mPopAll = (Button) findViewById(R.id.popAll);
        mPopBeat = (Button) findViewById(R.id.popBeat);
        mPopDisco = (Button) findViewById(R.id.popDisco);
        mPopFolk = (Button) findViewById(R.id.popFolk);
        mPopIndie = (Button) findViewById(R.id.popIndie);
        mPopPunk = (Button) findViewById(R.id.popPunk);

        mPopAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Pop","");
            }
        });
        mPopBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Pop","Beat");
            }
        });
        mPopPunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Pop","Punk");
            }
        });
        mPopFolk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Pop","Folk");
            }
        });
        mPopIndie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Pop","Indie");
            }
        });
        mPopDisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Pop","Disco");
            }
        });


        mJazzAll = (Button) findViewById(R.id.jazzAll);
        mJazzBeat = (Button) findViewById(R.id.jazzBeat);
        mJazzCool = (Button) findViewById(R.id.jazzCool);
        mJazzFree = (Button) findViewById(R.id.jazzFree);
        mJazzFolk = (Button) findViewById(R.id.jazzFolk);
        mJazzHeavy = (Button) findViewById(R.id.jazzHeavy);
        mJazzSoul = (Button) findViewById(R.id.jazzSoul);


        mJazzAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","");
            }
        });
        mJazzBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","Beat");
            }
        });
        mJazzSoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","Soul");
            }
        });
        mJazzHeavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","Heavy");
            }
        });
        mJazzCool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","Coolk");
            }
        });
        mJazzFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","Free");
            }
        });

        mJazzFolk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Jazz","Folk");
            }
        });


        mBluesAll = (Button) findViewById(R.id.bluesAll);
        mBluesCool = (Button) findViewById(R.id.bluesCool);
        mBluesFolk = (Button) findViewById(R.id.bluesFolk);
        mBluesBeat = (Button) findViewById(R.id.bluesBeat);
        mBluesIndie = (Button) findViewById(R.id.bluesIndie);

        mBluesIndie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Blues","Indie");
            }
        });

        mBluesCool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Blues","Cool");
            }
        });

        mBluesBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Blues","Beat");
            }
        });
        mBluesAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Blues","");
            }
        });

        mBluesIndie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Blues","Indie");
            }
        });

        mCountryAll = (Button) findViewById(R.id.countryAll);
        mCountryBeat = (Button) findViewById(R.id.countryBeat);
        mCountryFolk = (Button) findViewById(R.id.countryFolk);
        mCountryIndie = (Button) findViewById(R.id.countryIndie);
        mCountryRock = (Button) findViewById(R.id.countryRock);

        mCountryRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Country","Rock");
            }
        });

        mCountryIndie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Country","Indie");
            }
        });

        mCountryAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Country","");
            }
        });
        mCountryBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Country","Beat");
            }
        });

        mCountryFolk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGenreandSubGenre("Country","Folk");
            }
        });


    }

}
