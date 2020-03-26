package com.example.internshiptask.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.internshiptask.R;
import com.example.internshiptask.databinding.FragmentCh3Binding;

public class ChannelThreeFragment extends Fragment {

    FragmentCh3Binding binding3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding3 = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ch3, container, false);
        View view = binding3.getRoot();

        return view;
    }
}
