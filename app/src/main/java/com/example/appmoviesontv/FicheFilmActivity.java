package com.example.appmoviesontv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FicheFilmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_film);
        Intent intent = getIntent();
        String backdrop_path = intent.getStringExtra("backdrop_path");
        String original_language = intent.getStringExtra("original_language");
        String original_title = intent.getStringExtra("original_title");
        String overview = intent.getStringExtra("overview");
        String poster_path = intent.getStringExtra("poster_path");
        String runtime = intent.getStringExtra("runtime");
       // String genres = intent.getStringExtra("genres");
        String title = intent.getStringExtra("title");
        String chaine = intent.getStringExtra("chaine");
        String dateonair = intent.getStringExtra("dateonair");
        String hourenair = intent.getStringExtra("hourenair");
        String tmdb = intent.getStringExtra("tmdb");
        String year = intent.getStringExtra("year");

        ImageView affiche = findViewById(R.id.img_affiche);
        ImageView fichebackdrop_path = findViewById(R.id.img_back);
        TextView textetitle = findViewById(R.id.title);
        TextView texteoriginal_title = findViewById(R.id.titleOriginal);
        TextView texteyear = findViewById(R.id.year);
        TextView textechaine = findViewById(R.id.chaine);
        TextView texteheure = findViewById(R.id.heure);
        //TextView textegenres = findViewById(R.id.genres);
        TextView texteoverview = findViewById(R.id.overview);
        TextView texteruntime = findViewById(R.id.runtime);

        textetitle.setText(title);
        texteruntime.setText(runtime);
        texteoriginal_title.setText(original_title);
        texteyear.setText(year);
        textechaine.setText(chaine);
        texteheure.setText(hourenair);
       // textegenres.setText(genres);
        texteoverview.setText(overview);
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+ poster_path).into(affiche);
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+backdrop_path).into(fichebackdrop_path);

    }

    public void bBackClic(View view) {
        Intent intent = new Intent(FicheFilmActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
