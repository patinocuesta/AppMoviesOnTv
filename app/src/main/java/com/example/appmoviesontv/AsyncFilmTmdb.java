package com.example.appmoviesontv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AsyncFilmTmdb extends AsyncTask<String,Integer, FilmTmdb> {

    private String action=null; // déclaration , connu dans doInBackGround
    public static FilmTmdb filmTmdb;
    @SuppressLint("StaticFieldLeak")
    private Activity activity;
// on va initialiser un constructeur: par generate => constructor
    AsyncFilmTmdb(Activity activity) { this.activity = activity; }

    @Override
    protected FilmTmdb doInBackground(String... strings) {
        String connection=strings[0];
        action=strings[1]; // déclaré en global
        String film=strings[2];
        int id= Integer.parseInt(strings[3]);
        if (action.equals("GET")){
        filmTmdb=getFilmTmdb(connection);
        Asynchrone.filmTmdb=filmTmdb;
        //Log.d("Loading filmTmdb",filmTmdb.toString());
        }
        // if (action.equals("GET")) getAllFilms(connection);
        return filmTmdb;
        }// fin de doInBackground


    private FilmTmdb parsejsonFile(String jString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jString);
            //on récupère le 1er objet JSON:
         //   String id=jsonObject.getString("id");
         //   Log.d("JSONObject ",id);
            String backdrop_path=jsonObject.getString("backdrop_path");
         //   Log.d("JSONObject ",backdrop_path);
            String original_language=jsonObject.getString("original_language");
          //  Log.d("JSONObject ",original_language);
            String original_title=jsonObject.getString("original_title");
         //   Log.d("JSONObject ",original_title);
            String overview=jsonObject.getString("overview");
         //   Log.d("JSONObject ",overview);
            String poster_path=jsonObject.getString("poster_path");
         //   Log.d("JSONObject ",poster_path);
            String runtime=jsonObject.getString("runtime");
         //   Log.d("JSONObject ",runtime);
         //   String title=jsonObject.getString("title");
          //  Log.d("JSONObject ",title);
            ArrayList<String> genres =new ArrayList<>();
            JSONArray genresJson = jsonObject.getJSONArray("genres");
        for (int i=0; i<genresJson.length();i++) {
            JSONObject jsonObjectGenres =genresJson.getJSONObject(i);
            String genreItem=jsonObjectGenres.getString("name");
            genres.add(genreItem);
        }
        Film film = new Film("","","","","","","");
        FilmTmdb filmTmdb1=new FilmTmdb(backdrop_path, genres, original_language,original_title,
                            overview,poster_path, runtime,film);
        return filmTmdb1;
    }// fin de la métode: parsejsonFile

    private FilmTmdb getFilmTmdb (String connection){
        //initialiser la connection à null
        HttpURLConnection httpURLConnection=null;
        //definir un objet
        String resultat=null;
        FilmTmdb filmTmdb = null;
        try {
            URL url=new URL(connection);
            //initialiser la connexion
            //try {
            httpURLConnection= (HttpURLConnection) url.openConnection();
            //pour lire les données:
            InputStream inputStream= new BufferedInputStream(httpURLConnection.getInputStream());
            //boucle dans le strinbuilder: recupere json pour le traiter:
            int inChar;
            StringBuilder readStr=new StringBuilder();
            //boucle pour lire sur le flux de lecture char par char:
            while ((inChar=inputStream.read())!=-1){
                readStr.append((char)inChar);
            }
            //recuperer le resultat:
            resultat=readStr.toString();

            //on parse le resultat qui va convertir la chaine en json
            //et parser le JSON: cette methoe n'est pas encore créée:
            try {
                filmTmdb=parsejsonFile(resultat);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //fermerla ressource:
            inputStream.close();
            httpURLConnection.disconnect();
            //} catch (MalformedURLException e) {
            // mieux le choix catch suivan{t
            //   e.printStackTrace();
            // on supprime ce catch car IOException est une erreur générique de 'Malfored...'
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmTmdb;
    } // fin de la methode getAllFilms
}
