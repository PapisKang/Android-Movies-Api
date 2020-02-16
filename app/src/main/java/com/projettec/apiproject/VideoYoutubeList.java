package com.projettec.apiproject;

import java.util.List;

public class VideoYoutubeList {
    private List<VideoYoutube> results;

    public VideoYoutubeList(List<VideoYoutube> results) {
        this.results = results;
    }

    public List<VideoYoutube> getResults() {
        return results;
    }

    public void setResults(List<VideoYoutube> results) {
        this.results = results;
    }
}
