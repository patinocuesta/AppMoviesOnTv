package com.example.appmoviesontv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String action=null;
    Film FilmMaj=null;
    ListView listView;
    public static ArrayList<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.liste);
        //listView.setOnItemClickListener(this);
        Asynchrone as=new Asynchrone(this);
        String[] parametres={"http://10.0.2.2:3000/api/today","GET",null,"0"};
        as.execute(parametres);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // on doir récupérer le livre correspondant à la sélection:
        // position représente l'indice dans l'ArrayListe de Livre
        FilmMaj=MainActivity.films.get(position);// c'est l'id dans l'Array
    }
}
