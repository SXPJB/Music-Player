package com.fsociety.reproductoresteso;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ListMusicActiviy extends AppCompatActivity {

    private TextView textViewArtistName;
    private TextView textViewAlbumName;
    private ImageView imageViewAlbum;
    private List<Music> listMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);
        textViewArtistName=(TextView)findViewById(R.id.textView_ArtistName);
        imageViewAlbum=(ImageView)findViewById(R.id.imageView_Album);
        textViewAlbumName=(TextView)findViewById(R.id.textView_AlbumName);
        final Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        textViewArtistName.setText(bundle.getString("artistName"));
        textViewAlbumName.setText(bundle.getString("albumName"));
        imageViewAlbum.setImageResource(bundle.getInt("imageAlbum"));
        setListAlbumMusic(bundle.getString("artistName"));
        AdapterMusic adapterMusic=new AdapterMusic(this);
        final ListView listViewMusic=findViewById(R.id.listViewMusic);
        listViewMusic.setAdapter(adapterMusic);
        listViewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ListMusicActiviy.this,MusicPlayerActivity.class);
                intent.putExtra("nameSong",listMusic.get(position).getNameSong());
                intent.putExtra("song",listMusic.get(position).getSong());
                intent.putExtra("imageSong",bundle.getInt("imageAlbum"));
                startActivity(intent);
            }
        });
    }

    private void setListAlbumMusic(String artistName) {
        switch (artistName){
            case "Tiesto":
                listMusic=new ArrayList<>();
                listMusic.add(new Music("Ten Seconds Before Sunris"," 7:31",R.raw.tensecondsbeforesunrise));
                listMusic.add(new Music("Everything"," 7:03",R.raw.everything));
                listMusic.add(new Music("Do You Feel Me"," 6:05",R.raw.doyoufeelme));
                listMusic.add(new Music("Carpe Noctum"," 7:05",R.raw.carpenoctum));
                listMusic.add(new Music("Driving to Heaven"," 4:44",R.raw.drivingtoheaven));
                listMusic.add(new Music("Sweet Thing"," 5:42",R.raw.sweetthings));
                listMusic.add(new Music("Elements of Life"," 8:25",R.raw.elementsoflife));
                break;
            case "Armin van buuren":
                listMusic=new ArrayList<>();
                listMusic.add(new Music("Sucker For Love"," 2:56",R.raw.suckerforlove));
                listMusic.add(new Music("Something Real"," 2:59",R.raw.somethingreal));
                listMusic.add(new Music("Wild Wild Son"," 3:33",R.raw.wildwildson));
                listMusic.add(new Music("Phone Down"," 3:12",R.raw.phonedown));
                listMusic.add(new Music("Blah Blah Blah"," 3:03",R.raw.blahblahblah));
                listMusic.add(new Music("High On Your Love"," 3:08",R.raw.highonyour));
            break;
            case "The Chainsmokers":
                listMusic=new ArrayList<>();
                listMusic.add(new Music("The Reaper","3:04",R.raw.thereaper));
                listMusic.add(new Music("Family","3:21",R.raw.family));
                listMusic.add(new Music("See the Way","2:56",R.raw.seetheway));
                listMusic.add(new Music("Push My Luck","3:01",R.raw.pushmyluck));
                listMusic.add(new Music("Call You Mine","3:37",R.raw.callyoumine));
                break;
            case "Cosmic Gate":
                listMusic=new ArrayList<>();
               listMusic.add(new Music("Happyness","6:21",R.raw.happyness));
                listMusic.add(new Music("Falling Back","4:39",R.raw.fallingback));
               listMusic.add(new Music("Fair Game","4:56",R.raw.fairgame));
                listMusic.add(new Music("Start To Feel","5:45",R.raw.starttofeel));
               listMusic.add(new Music("Shine Forever","5:32",R.raw.shineforever));
                break;
            case "Lindsey stirling":
                listMusic=new ArrayList<>();
                listMusic.add(new Music("Underground","4:24",R.raw.underground));
                listMusic.add(new Music("Artemis","3:53",R.raw.artemis));
                listMusic.add(new Music("Til the Light Goes Out","4:46",R.raw.tilthelightgoesout));
                listMusic.add(new Music("Between Twilight","4:19",R.raw.betweentwilight));
                break;
            case "Coldplay":
                    listMusic=new ArrayList<>();
                    listMusic.add(new Music("Politik","5:18",R.raw.politik));
                    listMusic.add(new Music("God Put a Smile upon Your Face","4:57",R.raw.godputsmileuponyourface));
                    listMusic.add(new Music("The Scientist","5:09",R.raw.thescientist));
                    listMusic.add(new Music("Clocks","5:07",R.raw.clocks));
                    break;
                default:
                    listMusic=new ArrayList<>();
        }

    }

    class AdapterMusic extends ArrayAdapter<Music>{

        AppCompatActivity appCompatActivity;

        AdapterMusic(AppCompatActivity context) {
            super(context, R.layout.template_list_songs, listMusic);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View music=inflater.inflate(R.layout.template_list_songs,null);

            TextView textViewMusic=(TextView)music.findViewById(R.id.textViewNameSong);
            textViewMusic.setText(listMusic.get(position).getNameSong());

            TextView textViewTime=(TextView)music.findViewById(R.id.textViewTime);
            textViewTime.setText(listMusic.get(position).getTimeSong());

            return music;
        }
    }
}
