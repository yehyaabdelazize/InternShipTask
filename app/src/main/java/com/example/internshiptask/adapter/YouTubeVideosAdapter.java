package com.example.internshiptask.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.internshiptask.R;
import com.example.internshiptask.models.YouTubeVideos;
import com.example.internshiptask.ui.activities.YTubeVideoActivity;

import java.util.List;

public class YouTubeVideosAdapter extends RecyclerView.Adapter<YouTubeVideosAdapter.VideoViewHolder> {

    Context context;
    List<YouTubeVideos> youTubeVideos;

    public YouTubeVideosAdapter() {
    }

    public YouTubeVideosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem, parent, false);

        return new VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {


        holder.videoWeb.loadData(youTubeVideos.get(position).getVideoUrl(),
                "text/html", "utf-8");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YTubeVideoActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (youTubeVideos != null) {
            return youTubeVideos.size();
        } else {
            return 0;
        }

    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        WebView videoWeb;

        public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = itemView.findViewById(R.id.videoWebView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {

            });
        }
    }

    public void setYouTubeVideos(List<YouTubeVideos> youTubeVideos) {
        this.youTubeVideos = youTubeVideos;
    }
}
