package com.example.internshiptask.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.internshiptask.R;
import com.example.internshiptask.databinding.ActivityBottomNavBinding;
import com.example.internshiptask.ui.fragments.ChannelOneFragment;
import com.example.internshiptask.ui.fragments.ChannelTwoFragment;
import com.example.internshiptask.ui.fragments.ChannelThreeFragment;
import com.example.internshiptask.ui.fragments.ChannelFourFragment;
import com.example.internshiptask.ui.fragments.ChannelFiveFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class YTubeChannelsActivity extends AppCompatActivity {

    private ActivityBottomNavBinding bottomNavBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomNavBinding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_nav);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragmentg = new ChannelOneFragment();
        fragmentTransaction.add(R.id.fragment_container_galisa, fragmentg);
        fragmentTransaction.commit();
        bottomNavBinding.navigationg.setOnNavigationItemSelectedListener(navlistnerg);



    }


    public BottomNavigationView.OnNavigationItemSelectedListener navlistnerg =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId()) {

                        case R.id.ch1:
                            fragment = new ChannelOneFragment();
                            break;
                        case R.id.ch2:
                            fragment = new ChannelTwoFragment();
                            break;
                        case R.id.ch3:
                            fragment = new ChannelThreeFragment();
                            break;
                        case R.id.ch4:
                            fragment = new ChannelFourFragment();
                            break;
                        case R.id.ch5:
                            fragment = new ChannelFiveFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_galisa,
                            fragment).commit();
                    return true;
                }

            };

}
