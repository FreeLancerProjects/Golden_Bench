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
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.Locale;

import io.paperdb.Paper;

public class FragmentAgents extends Fragment {
    private HomeplayerActivity activity;
    private FragmentOrdersBinding binding;
    private Preferences preferences;

    private String lang;

    public static FragmentAgents newInstance()
    {
        return new FragmentAgents();
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
lang = Paper.book().read("lang", Locale.getDefault().getLanguage());



    }

}
