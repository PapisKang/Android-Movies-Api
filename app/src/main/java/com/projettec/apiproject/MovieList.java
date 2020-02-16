package com.projettec.apiproject;

public class MovieList {

    private String id;
    private String title;
    private String overview;
    private String backdrop_path;
    private String poster_path;
    private String  original_title;

    public MovieList(String id, String title, String overview, String backdrop_path, String poster_path, String original_title) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.original_title = original_title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }
}
