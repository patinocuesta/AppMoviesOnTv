package com.example.appmoviesontv;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FilmTmdb {
    private String backdrop_path;
    private ArrayList<String> genres;
    private String id;
    private String original_language;
    private String original_title;
    private String overview;
    private String poster_path;
    private String runtime;
    private String title;

    public FilmTmdb(String backdrop_path, ArrayList<String> genres, String id, String original_language, String original_title, String overview, String poster_path, String runtime, String title) {
        this.backdrop_path = backdrop_path;
        this.genres = genres;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.runtime = runtime;
        this.title = title;
    }
public FilmTmdb(){}

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FilmTmdb{" +
                "backdrop_path='" + backdrop_path + '\'' +
                ", genres=" + genres +
                ", id='" + id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", runtime='" + runtime + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
