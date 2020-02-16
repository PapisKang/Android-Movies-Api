package com.projettec.apiproject;

import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoYoutubeHolder  extends RecyclerView.ViewHolder{

    private WebView videoWeb;

    public VideoYoutubeHolder(@NonNull View itemView) {
        super(itemView);

        videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);

        videoWeb.getSettings().setJavaScriptEnabled(true);
        videoWeb.setWebChromeClient(new WebChromeClient() {

        } );

    }
    void display(VideoYoutube videoYoutube){
        String a="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"+videoYoutube.getKey()+"\" frameborder=\"0\" allowfullscreen></iframe>";
        videoWeb.loadData( a, "text/html" , "utf-8" );
    }
}
