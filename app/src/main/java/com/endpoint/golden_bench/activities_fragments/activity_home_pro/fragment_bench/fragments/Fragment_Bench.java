package com.endpoint.golden_bench.activities_fragments.activity_home_pro.fragment_bench.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_pro.HomeproActivity;
import com.endpoint.golden_bench.adapter.ViewPagerTitleAdapter;
import com.endpoint.golden_bench.databinding.FragmentBenchBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Bench extends Fragment {
    private static Dialog dialog;
    private HomeproActivity activity;
    private FragmentBenchBinding binding;
    private String lang;
    private List<Fragment> fragmentList;
    private List<String> titles;
    private ViewPagerTitleAdapter adapter;

    private Preferences preferences;
    private UserModel userModel;

    public static Fragment_Bench newInstance() {
        return new Fragment_Bench();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bench, container, false);
        initView();


        return binding.getRoot();
    }


    private void initView() {
        activity = (HomeproActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        binding.tab1.setupWithViewPager(binding.pager);
        addFragments_Titles();
        binding.pager.setOffscreenPageLimit(fragmentList.size());
        adapter = new ViewPagerTitleAdapter(getChildFragmentManager());
        adapter.addFragments(fragmentList);
        adapter.addTitles(titles);
        binding.pager.setAdapter(adapter);
        binding.tab12.setVisibility(View.GONE);
        binding.tab1.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.pager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    binding.tab12.setVisibility(View.GONE);

                }
                else {
                    binding.tab12.setVisibility(View.VISIBLE);

                }
//                Log.e("kk",viewPager.getAdapter().getPageTitle(0).toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void addFragments_Titles() {
        fragmentList.add(FragmentAgents.newInstance());
        fragmentList.add(FragmentPlayers.newInstance());


        titles.add(getString(R.string.agents));
        titles.add(getString(R.string.player));

    }

}
