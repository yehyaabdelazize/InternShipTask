package com.example.internshiptask.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.internshiptask.R;
import com.example.internshiptask.adapter.YouTubeVideosAdapter;
import com.example.internshiptask.databinding.FragmentCh1Binding;
import com.example.internshiptask.models.YouTubeVideos;
import com.example.internshiptask.viewmodel.YTubeChannelsViewModel;

import java.util.Vector;

public class ChannelOneFragment extends Fragment {
    FragmentCh1Binding binding1;
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
        binding1 = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ch1, container, false);
        View view = binding1.getRoot();
        binding1.channelname.setText(" Udacity ");


        binding1.recycler.setHasFixedSize(true);
        binding1.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        videoAdapter = new YouTubeVideosAdapter();
        binding1.recycler.setAdapter(videoAdapter);

        return view;
    }


    private void subscribeObservers() {
        yTubeChannelsViewModel.youTubeChannels1().observe(this, videos -> {
            videoAdapter.setYouTubeVideos(videos);
        });
    }

}
