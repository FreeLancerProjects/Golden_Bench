package com.endpoint.golden_bench.activities_fragments.activity_home.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home.HomeActivity;
import com.endpoint.golden_bench.databinding.FragmentProfileFollowerBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_profile extends Fragment {

    private HomeActivity activity;
    private FragmentProfileFollowerBinding binding;
    private Preferences preferences;
    private String lang;
    private UserModel userModel;

    public static Fragment_profile newInstance() {

        return new Fragment_profile();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_follower, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);

        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
    }


}
