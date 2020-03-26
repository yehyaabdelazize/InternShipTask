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
import com.example.internshiptask.databinding.FragmentCh4Binding;
import com.example.internshiptask.viewmodel.YTubeChannelsViewModel;

public class ChannelFourFragment extends Fragment {

    FragmentCh4Binding binding4;
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
        binding4 = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ch4, container, false);
        View view = binding4.getRoot();

        binding4.channelname.setText(" CodingWithSmith ");
        binding4.recycler.setHasFixedSize(true);
        binding4.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        videoAdapter = new YouTubeVideosAdapter();
        binding4.recycler.setAdapter(videoAdapter);


        return view;
    }
    private void subscribeObservers() {
        yTubeChannelsViewModel.youTubeChannels4().observe(this, videos -> {
            videoAdapter.setYouTubeVideos(videos);
        });
    }

}
