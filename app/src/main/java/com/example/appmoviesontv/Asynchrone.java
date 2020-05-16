package com.example.appmoviesontv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Asynchrone extends AsyncTask<String,Integer, ArrayList<Film>> {
    private String action=null; // déclaration , connu dans doInBackGround
    @SuppressLint("StaticFieldLeak")
    private Activity activity;
    // on va initialiser un constructeur: par generate => constructor
    Asynchrone(Activity activity) { this.activity = activity; }

    @Override
    protected ArrayList<Film> doInBackground(String... strings) {
        ArrayList<Film> liste = new ArrayList<Film>();
        String connection=strings[0];
        action=strings[1]; // déclaré en global
        String film=strings[2];
        int id= Integer.parseInt(strings[3]);
        if (action.equals("GET")){
            liste=getAllFilms(connection);
            MainActivity.films=liste;
            for (Film s1:liste){
                Log.d("Loading titles",s1.toString());
            }
        }
       // if (action.equals("GET")) getAllFilms(connection);
        return liste;
    }// fin de doInBackground

    @Override
    protected void onPostExecute(ArrayList<Film> s) {
        // s est l'ArrayList<Livre>
        super.onPostExecute(s);
        // dans le cas où action = GET, on doit afficher la liste des livres
        //dans une ListView à partir des Données envoyées par la méthode doInBackGround
        //sinon on ne fait rien.
        //la classe AsyncTask n'est pas une activity, ne donnera pas de context voir etape 1
        //on va definir un ArrayA après avoir créé danslayout pour la listView:
        if (action.equals("GET")) {
            ArrayAdapter<Film> aa = new ArrayAdapter<Film>(this.activity,
                    android.R.layout.simple_list_item_single_choice, s);
            //récupéerer la liste: le find id ne marche pas comme context ==>
            ListView listView = activity.findViewById(R.id.liste);
            //affecter à la liste
            listView.setAdapter(aa);
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // une constante statique
            //avec le GET pas de pb; mais pas avec POST, PUT, DELETE ==> voir plus haut
            //doInBackGround
            //==> une autre activity
        }
        //Toast.makeText(this.activity,"OK",Toast.LENGTH_LONG).show();
    }
    private ArrayList<Film> parsejsonFile(String jString) throws JSONException {
        JSONArray filmarray= new JSONArray(jString);
        ArrayList<Film> listfilms=new ArrayList<Film>();
        //JSONObject jsonObject=new JSONObject(jString);
       // JSONObject films=jsonObject.getJSONObject("films");
       //JSONArray film=films.getJSONArray("film");

        for (int i=0; i<filmarray.length();i++){
            JSONObject jsonObject=filmarray.getJSONObject(i);
            //on récupère le 1er objet JSON:
            String _id=jsonObject.getString("_id");
            Log.d("JSONObject ",_id);
            String title=jsonObject.getString("title");
            Log.d("JSONObject ",title);
            String year=jsonObject.getString("year");
            Log.d("JSONObject ",year);
            String tmdb=jsonObject.getString("tmdb");
            Log.d("JSONObject ",tmdb);
            Film film1=new Film(_id,title,year,tmdb, "test", "test","test");
            listfilms.add(film1);
        }// fin de la boucle for
        return listfilms;
    }// fin de la métode: parsejsonFile
    private ArrayList<Film> getAllFilms(String connection){
        //initialiser la connection à null
        HttpURLConnection httpURLConnection=null;
        //definir un objet
        String resultat=null;
        ArrayList<Film> listFilms = null;
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
                listFilms=parsejsonFile(resultat);
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
        assert listFilms != null;
        for (Film l:listFilms)  Log.d("JSONObjectListe",l.toString());
        return listFilms;
    } // fin de la methode getAllFilms

}// fin de la classe AsyncTask
