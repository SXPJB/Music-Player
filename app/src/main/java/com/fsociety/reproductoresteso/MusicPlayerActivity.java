package com.fsociety.reproductoresteso;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MusicPlayerActivity extends AppCompatActivity {

    private TextView textViewNameSong;
    private ImageView imageViewAlbum;
    private MediaPlayer mediaPlayer;
    private int position=0;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        textViewNameSong=(TextView)findViewById(R.id.textView_NameSong);
        imageViewAlbum=(ImageView)findViewById(R.id.imageView_Album1);
        bundle=getIntent().getExtras();
        assert bundle!=null;
        textViewNameSong.setText(bundle.getString("nameSong"));
        imageViewAlbum.setImageResource(bundle.getInt("imageSong"));
    }
    public void destroy() {
        if (mediaPlayer != null)
            mediaPlayer.release();
    }
    public void playMusic(View view) {
        destroy();
        mediaPlayer = MediaPlayer.create(this, bundle.getInt("song"));
        mediaPlayer.start();
        Toast.makeText(this,"Se inicio la cancion",Toast.LENGTH_SHORT).show();
    }
    public void pause(View view){
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            position = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
            Toast.makeText(this,"Se pauso la cancion",Toast.LENGTH_SHORT).show();
        }
    }

    public void goOn(View view){
        if (mediaPlayer != null && mediaPlayer.isPlaying() == false) {
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
            Toast.makeText(this,"Continua la cancion",Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            position = 0;
            Toast.makeText(this,"Se detubo la cancion",Toast.LENGTH_SHORT).show();
        }
    }

    public void gotBackList(View view){
        stop(view);
        destroy();
    }
}
