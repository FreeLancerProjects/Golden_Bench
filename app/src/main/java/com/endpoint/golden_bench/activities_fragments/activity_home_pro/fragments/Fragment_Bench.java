package com.endpoint.golden_bench.activities_fragments.activity_home_pro.fragments;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_pro.HomeProActivity;
import com.endpoint.golden_bench.databinding.FragmentBenchBinding;
import com.endpoint.golden_bench.preferences.Preferences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Bench extends Fragment {

    private HomeProActivity activity;
    private FragmentBenchBinding binding;
    private Preferences preferences;

    private String lang;

    public static Fragment_Bench newInstance() {
        return new Fragment_Bench();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bench,container,false);
        initView();
        return binding.getRoot();
    }

    private void initView() {


        activity = (HomeProActivity) getActivity();
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());preferences = Preferences.getInstance();



    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
