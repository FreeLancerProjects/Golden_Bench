package com.endpoint.golden_bench.activities_fragments.activity_home_follow.fragments.fragment_profile;

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
import com.endpoint.golden_bench.activities_fragments.activity_home_follow.HomeFollowerActivity;
import com.endpoint.golden_bench.adapter.ViewPagerTitleAdapter;
import com.endpoint.golden_bench.databinding.FragmentProfileFollowerBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Profile extends Fragment {
    private static Dialog dialog;
    private HomeFollowerActivity activity;
    private FragmentProfileFollowerBinding binding;
    private String lang;
    private List<Fragment> fragmentList;
    private List<String> titles;
    private ViewPagerTitleAdapter adapter;

    private Preferences preferences;
    private UserModel userModel;

    public static Fragment_Profile newInstance() {
        return new Fragment_Profile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_follower, container, false);
        initView();


        return binding.getRoot();
    }


    private void initView() {
        activity = (HomeFollowerActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        binding.tab.setupWithViewPager(binding.pager);
        addFragments_Titles();
        binding.pager.setOffscreenPageLimit(fragmentList.size());
        adapter = new ViewPagerTitleAdapter(getChildFragmentManager());
        adapter.addFragments(fragmentList);
        adapter.addTitles(titles);
        binding.pager.setAdapter(adapter);

        binding.appBar.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, verticalOffset) -> {
            int total_rang = appBarLayout.getTotalScrollRange();
            if ((total_rang + verticalOffset) > 70) {


                        binding.ll.setVisibility(View.VISIBLE);



                } else {
                    binding.ll.setVisibility(View.GONE);

                }


        });
    }

    private void addFragments_Titles() {
        fragmentList.add(FragmentFavourite.newInstance());
        fragmentList.add(FragmentFollowers.newInstance());


        titles.add(getString(R.string.favourite));
        titles.add(getString(R.string.followers));

    }

}
