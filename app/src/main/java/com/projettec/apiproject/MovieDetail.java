package com.projettec.apiproject;

import java.util.List;

public class MovieDetail {

    private String id;
    private String title;
    private String overview;
    private String backdrop_path;
    private List<Genre> genres;
    private String vote_average;
    private String vote_count;
    private String release_date;
    private String original_language;
    private List<Production_companie> production_companies;
    private String homepage;
    private String runtime;

    public MovieDetail(String id, String title, String overview, String backdrop_path, List<Genre> genres, String vote_average, String vote_count, String release_date, String original_language, List<Production_companie> production_companies, String homepage, String runtime) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.genres = genres;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.release_date = release_date;
        this.original_language = original_language;
        this.production_companies = production_companies;
        this.homepage = homepage;
        this.runtime = runtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public List<Production_companie> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Production_companie> production_companies) {
        this.production_companies = production_companies;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}
