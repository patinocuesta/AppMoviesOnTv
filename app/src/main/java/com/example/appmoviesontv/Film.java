package com.example.appmoviesontv;

import java.io.Serializable;

public class Film implements Serializable {
    private String _id;
    private String title;
    private String year;
    private String tmdb;
    private String chaine;
    private String dateonair;
    private String hourenair;

    public Film(String _id, String title, String year, String tmdb, String chaine, String dateonair, String hourenair) {
        this._id = _id;
        this.title = title;
        this.year = year;
        this.tmdb = tmdb;
        this.chaine = chaine;
        this.dateonair = dateonair;
        this.hourenair = hourenair;
    }


    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getTmdb() {
        return tmdb;
    }

    public String getChaine() {
        return chaine;
    }

    public String getDateonair() {
        return dateonair;
    }

    public String getHourenair() {
        return hourenair;
    }

    @Override
    public String toString() {
        return "Film{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", tmdb='" + tmdb + '\'' +
                ", chaine='" + chaine + '\'' +
                ", dateonair='" + dateonair + '\'' +
                ", hourenair='" + hourenair + '\'' +
                '}';
    }
}
