package com.example.abcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Detailabc extends AppCompatActivity {
    MediaPlayer player;
    ListView list;
    ImageView myImg;
    TextView myText;
    String music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailabc);

        myImg=findViewById(R.id.myimage);
        myText=findViewById(R.id.myTitle);
        Intent intent = getIntent();
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("images");
        String title = intent.getStringExtra("title");
        music = intent.getStringExtra("desc");
        myImg.setImageResource(pic);
        myText.setText(title);
    }
    public void play(View view) {
        int sound_id = this.getResources().getIdentifier(music, "raw",
                this.getPackageName());
        if(player==null)
            player=MediaPlayer.create(this,sound_id);
        player.start();
    }
}