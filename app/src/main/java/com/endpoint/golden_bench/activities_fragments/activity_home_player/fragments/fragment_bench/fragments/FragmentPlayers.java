package com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments.fragment_bench.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_player.HomeplayerActivity;
import com.endpoint.golden_bench.databinding.FragmentOrdersBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import io.paperdb.Paper;

public class FragmentPlayers extends Fragment {
    private HomeplayerActivity activity;
    private FragmentOrdersBinding binding;
    private Preferences preferences;

private UserModel userModel;

    public static FragmentPlayers newInstance()
    {
        return new FragmentPlayers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {

        preferences = Preferences.getInstance();
        activity = (HomeplayerActivity) getActivity();
        Paper.init(activity);


    }

}
