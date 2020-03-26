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
import com.example.internshiptask.databinding.FragmentCh5Binding;

public class ChannelFiveFragment extends Fragment {

    FragmentCh5Binding binding5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding5 = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ch5, container, false);
        View view = binding5.getRoot();

        return view;
    }
}
