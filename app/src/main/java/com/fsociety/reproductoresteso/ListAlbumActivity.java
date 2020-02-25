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

public class ListAlbumActivity extends AppCompatActivity {

    List<Album> listAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_album);
        fillListAlbum();
        AdapterAlbum adapterAlbum=new AdapterAlbum(this);
        final ListView listViewAlbum=(findViewById(R.id.listViewAlbum));
        listViewAlbum.setAdapter(adapterAlbum);
        listViewAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(ListAlbumActivity.this,ListMusicActiviy.class);
                intent.putExtra("artistName",listAlbum.get(position).getArtistName());
                intent.putExtra("albumName",listAlbum.get(position).getAlbumName());
                intent.putExtra("imageAlbum",listAlbum.get(position).getImageAlbum());
                startActivity(intent);
            }
        });
    }

    public void fillListAlbum(){
        listAlbum=new ArrayList<>();
        listAlbum.add(new Album ("Tiesto","Elemenst of life",R.mipmap.tiesto));
        listAlbum.add(new Album("Armin van buuren","Balance",R.mipmap.arminvanbuuren));
        listAlbum.add(new Album("The Chainsmokers","World War Joy",R.mipmap.chainsmokers));
        listAlbum.add(new Album("Cosmic Gate","Start to Feel",R.mipmap.starttofeel));
        listAlbum.add(new Album("Lindsey stirling","Artemis",R.mipmap.artemis));
        listAlbum.add(new Album("Coldplay","Rush of Blood",R.mipmap.clod));
    }

    class AdapterAlbum extends ArrayAdapter<Album> {

        AppCompatActivity appCompatActivity;

        AdapterAlbum(AppCompatActivity context) {
            super(context, R.layout.template_list_album, listAlbum);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View album = inflater.inflate(R.layout.template_list_album, null);

            TextView textViewArtistName = (TextView)album.findViewById(R.id.textViewArtistName);
            textViewArtistName.setText(listAlbum.get(position).getArtistName());

            TextView textViewAlbumName=(TextView)album.findViewById(R.id.textViewAlbumName);
            textViewAlbumName.setText(listAlbum.get(position).getAlbumName());

            ImageView imageViewAlbum = (ImageView)album.findViewById(R.id.imageViewAlbum);
            imageViewAlbum.setImageResource(listAlbum.get(position).getImageAlbum());
            return(album);
        }

    }
}
