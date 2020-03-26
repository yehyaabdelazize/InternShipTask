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
import com.example.internshiptask.databinding.FragmentCh5Binding;
import com.example.internshiptask.viewmodel.YTubeChannelsViewModel;

public class ChannelFiveFragment extends Fragment {

    FragmentCh5Binding binding5;
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
        binding5 = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ch5, container, false);
        View view = binding5.getRoot();

        binding5.channelname.setText(" CodingWithSmith ");
        binding5.recycler.setHasFixedSize(true);
        binding5.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        videoAdapter = new YouTubeVideosAdapter();
        binding5.recycler.setAdapter(videoAdapter);
        binding5.switchSubscribe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
        yTubeChannelsViewModel.youTubeChannels5().observe(this, videos -> {
            videoAdapter.setYouTubeVideos(videos);
        });
    }
}
