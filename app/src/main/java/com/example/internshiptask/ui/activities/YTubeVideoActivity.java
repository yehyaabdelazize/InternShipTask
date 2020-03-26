package com.example.internshiptask.ui.activities;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.internshiptask.R;
import com.example.internshiptask.databinding.ActivityPlayBinding;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class YTubeVideoActivity extends YouTubeBaseActivity {


    ActivityPlayBinding playBinding;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playBinding= DataBindingUtil.setContentView(this, R.layout.activity_play);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(youTubePlayer.toString());
                playBinding.youtubeplayerview.initialize("AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ",onInitializedListener);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

    }

}
