package com.example.internshiptask.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.internshiptask.R;
import com.example.internshiptask.adapter.YouTubeVideosAdapter;
import com.example.internshiptask.databinding.FragmentCh2Binding;
import com.example.internshiptask.models.YouTubeVideos;
import com.example.internshiptask.viewmodel.YTubeChannelsViewModel;

import java.util.Vector;

public class ChannelTwoFragment extends Fragment {

    FragmentCh2Binding binding2;
    Vector<YouTubeVideos> youtubeVideos = new Vector<>();
    private YTubeChannelsViewModel yTubeChannelsViewModel;
    private YouTubeVideosAdapter videoAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        yTubeChannelsViewModel = new ViewModelProvider(this).get(YTubeChannelsViewModel.class);
        subscribeObservers();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding2 = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ch2, container, false);
        View view = binding2.getRoot();

        binding2.channelname.setText(" Udemy ");
        binding2.recycler.setHasFixedSize(true);
        binding2.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        videoAdapter = new YouTubeVideosAdapter();
        binding2.recycler.setAdapter(videoAdapter);
        binding2.switchSubscribe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding5.subscribetxt.setText("subscribed");
                }
            }
        });

        return view;
    }
    private void subscribeObservers() {
        yTubeChannelsViewModel.youTubeChannels2().observe(this, videos -> {
            videoAdapter.setYouTubeVideos(videos);
        });
    }

}
