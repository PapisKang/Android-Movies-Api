package com.projettec.apiproject;

import java.util.List;

public class Movies {

    private List<MovieList> results;

    public Movies(List<MovieList> results) {
        this.results = results;
    }

    public List<MovieList> getResults() {
        return results;
    }

    public void setResults(List<MovieList> results) {
        this.results = results;
    }
}
